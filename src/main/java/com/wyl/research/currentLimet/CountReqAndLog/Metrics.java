package com.wyl.research.currentLimet.CountReqAndLog;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/26
 */
public class Metrics {

    /**
     * @Description: 为什么用list而不用成员变量计数?
     * @Date: 2020/5/26 11:06
     * @Idea: 因为成员变量计数需要加锁, 加锁会影响效率, 但是使用list需要及时清理list, 否则会内存溢出;
     */

    private Map<String, List<Double>> responseTimes = new HashMap<>();
    private Map<String, List<Double>> timestamps = new HashMap<>();

    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();


    public void recordResponseTime(String apiName, double responseTime) {
        responseTimes.putIfAbsent(apiName, new CopyOnWriteArrayList<>());
        responseTimes.get(apiName).add(responseTime);
    }

    public void recodTimestamp(String apiName, double timestamp) {
        timestamps.putIfAbsent(apiName, new CopyOnWriteArrayList<>());
        timestamps.get(apiName).add(timestamp);
    }

    public void startRepeatedReport(long period, TimeUnit timeUnit) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Map<String, Map<String, Double>> state = new HashMap<>();
                for (Map.Entry<String, List<Double>> entry : responseTimes.entrySet()) {
                    String apiName = entry.getKey();
                    List<Double> apiRespTimes = entry.getValue();
                    state.putIfAbsent(apiName, new HashMap<>());
                    state.get(apiName).put("max", max(apiRespTimes));
                    state.get(apiName).put("avg", avg(apiRespTimes));
                    state.get(apiName).put("size", (double) apiRespTimes.size());


                    if (apiRespTimes.size() > 2000) {
                        apiRespTimes.clear();
                    }
                }

                for (Map.Entry<String, List<Double>> entry : timestamps.entrySet()) {
                    String apiName = entry.getKey();
                    List<Double> apiTimeStamps = entry.getValue();
                    state.putIfAbsent(apiName, new HashMap<>());
                    state.get(apiName).put("count", (double) apiTimeStamps.size());
                    state.get(apiName).put("size", (double) apiTimeStamps.size());
                    if (apiTimeStamps.size() > 2000) {
                        apiTimeStamps.clear();
                    }
                }

                System.out.println("====>" + JSON.toJSONString(state));
                System.out.println("===============================================");

            }
        }, 0, period, timeUnit);


    }


    public Double max(List<Double> responseTimes) {
        return Collections.max(responseTimes);
    }

    public Double avg(List<Double> responseTimes) {
        double sum = 0;
        for (Double responseTime : responseTimes) {
            sum += responseTime;
        }
        double avg = sum / responseTimes.size();
        return avg;

    }


    public static void main(String[] args) throws InterruptedException {

        Metrics metrics = new Metrics();
        metrics.startRepeatedReport(1, TimeUnit.SECONDS);

        for (int i = 0; i < 1000000; i++) {
            long startTimestamp = System.currentTimeMillis();
            metrics.recodTimestamp("regsiter", startTimestamp);
            //...
            long respTime = System.currentTimeMillis() - startTimestamp;
            metrics.recordResponseTime("regsiter", respTime);
            Thread.currentThread().sleep(50);

            long startTimestamp2 = System.currentTimeMillis();
            metrics.recodTimestamp("login", startTimestamp2);
            //...
            long respTime2 = System.currentTimeMillis() - startTimestamp2;
            metrics.recordResponseTime("login", respTime2);

        }


    }


}
