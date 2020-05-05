package com.example.demo.zhaoyin.zhooyin;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/5
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = strSort(scan.next());
        System.out.println(s);
        scan.close();
    }


    public static String strSort(String str) {
        StringBuilder temp1 = new StringBuilder();
        StringBuilder temp2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*') {
                temp1 = temp1.append("*");
            } else {
                temp2 = temp2.append(str.charAt(i));
            }
        }

        String res = temp1.append(temp2).toString();
        return res;

    }

}
