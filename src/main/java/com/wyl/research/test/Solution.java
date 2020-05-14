package com.wyl.research.test;


import java.util.*;

class Solution {
    public static int dominantIndex(int[] nums) {
        int maxIndex = 0;
        int max = nums[0];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        System.out.println(max);
        for (int j : nums) {
            if (max <= j * 2) {
                return -1;
            }
        }
        return maxIndex;

    }

    public static int strStr(String haystack, String needle) {

        char[] str = haystack.toCharArray();
        for (int i = 0; i <= str.length - needle.length(); i++) {
            String temp = "";
            int index = i;
            for (int j = 0; j < needle.length(); j++) {
                temp = temp + str[index];
                index++;
            }
            if (temp.equals(needle)) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        findRestaurant(list1, list2);

    }

    public static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> container = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            container.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (container.containsKey(list2[i])) {
                int index_sum = container.get(list2[i]) + i;
                result.put(list2[i], index_sum);
            }
        }


        int min = list1.length + list2.length - 2;
        Set<String> res_set = new HashSet<>();
        Set<String> strings = result.keySet();
        for (String s : strings) {
            Integer temp = result.get(s);
            if (min > temp) {
                res_set.clear();
                res_set.add(s);
                min = temp;
            } else if (min == temp) {
                res_set.add(s);

            }
        }

        String[] res = new String[res_set.size()];
        int i = 0;
        Iterator<String> iterator = res_set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            res[i] = next;
            i++;
        }
        return res;

    }


}