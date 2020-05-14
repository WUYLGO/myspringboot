package com.wyl.research.huawei;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws IOException {




        Integer[] arr1 = new Integer[2];
        Integer[] arr2 = new Integer[2];
        Integer[] arr3 = new Integer[2];

        arr1[0] = 1;
        arr1[1] = 4;
        arr2[0] = 2;
        arr2[1] = 5;
        arr3[0] = 8;
        arr3[1] = 9;


        List<Integer[]> list4 = new CopyOnWriteArrayList<>();
        list4.add(arr1);
        list4.add(arr2);
        list4.add(arr3);

        List<Integer[]> list5 = new ArrayList<>();

        Integer[] temp = new Integer[2];
        temp[0] = list4.get(0)[0];
        temp[1] = list4.get(0)[1];
        for (int i = 1; i < list4.size() - 1; i++) {
            if (temp[1] > list4.get(i)[0]) {
                int min = Math.min(temp[0], list4.get(i)[0]);
                int max = Math.max(temp[1], list4.get(i)[1]);
                temp[0] = min;
                temp[1] = max;
                list5.add(temp);
            } else {
                list5.add(list4.get(i));
            }

        }
        System.out.println(JSON.toJSONString(list5));

    }


}