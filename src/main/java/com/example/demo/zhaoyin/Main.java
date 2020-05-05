package com.example.demo.zhaoyin;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/5
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String strs[] = scan.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (!list.contains(Integer.parseInt(strs[i]))) {
                list.add(Integer.parseInt(strs[i]));
            }
        }
        Collections.sort(list);
        int count = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j >= i; j--) {
                if (list.get(i) + list.get(j) < 24) {
                    break;
                }
                if (list.get(i) + list.get(j) == 24) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        scan.close();
    }


}
