package com.wyl.research.ali;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/1
 */
public class Aali0501 {


    public static Map<String, List<String>> getTopPickTimeOrderNos4Shop(List<String> orderNos, int n) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        List<OrderDetail> details = new ArrayList<>();
        for (int i = 0; i < 10000; i = i + 1000) {
            List<String> tempNos = new ArrayList<>();
            tempNos.addAll(orderNos.subList(i, i + 1000));
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    List<OrderDetail> partDetails = getDetails(tempNos);
                    details.addAll(partDetails);
                }
            });

        }


        Map<String, List<OrderDetail>> collect = details.stream().collect(Collectors.groupingBy(OrderDetail::getShopName));
        Set<Map.Entry<String, List<OrderDetail>>> entries = collect.entrySet();

        Map<String, List<String>> res = new HashMap<>();
        for (Map.Entry<String, List<OrderDetail>> entry : entries) {
            String shopName = entry.getKey();
            List<OrderDetail> orderDetails = entry.getValue();
            if (!CollectionUtils.isEmpty(orderDetails)) {
                List<String> topNOrders = topN(orderDetails, n);
                res.put(shopName, topNOrders);
            }
        }
        return res;
    }

    public static List<String> topN(List<OrderDetail> orderDetails, int n) {

        PriorityQueue<OrderDetail> queue = new PriorityQueue<>(new Comparator<OrderDetail>() {
            @Override
            public int compare(OrderDetail o1, OrderDetail o2) {
                if (o1.getPickTime() != null && o2.getPickTime() != null) {
                    return o2.getPickTime().compareTo(o1.pickTime);
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < orderDetails.size(); i++) {
            if (queue.size() < n) {
                queue.add(orderDetails.get(i));
            } else if (queue.size() == n) {
                if (queue.peek().getPickTime() < orderDetails.get(i).getPickTime()) {
                    queue.poll();
                    queue.add(orderDetails.get(i));
                }
            }
        }

        List<String> topNOrders = new ArrayList<>();
        topNOrders.add(queue.peek().getOrderNo());
        return topNOrders;
    }


    public static List<OrderDetail> getDetails(List<String> orderNos) {
        return null;
    }

    public class OrderDetail {
        /**
         * 订单编号
         */
        private String orderNo;
        /**
         * 拣货时间，单位为秒
         */
        private Long pickTime;
        /**
         * 盒马门店名称
         */
        private String shopName;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public Long getPickTime() {
            return pickTime;
        }

        public void setPickTime(Long pickTime) {
            this.pickTime = pickTime;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }
    }

}



