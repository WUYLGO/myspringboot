package com.example.demo.algrorithm;

import java.util.*;

class Solution15 {
    public static List<List<Integer>> findThreeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                int dec = 0 - nums[i] - nums[j];
                if (map.containsKey(dec) && map.get(dec) != i && map.get(dec) != j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(dec);
                    list.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });
                    res.add(list);
                }
            }
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.addAll(res);
        return resultList;

    }

    public static void main(String[] args) {

        findThreeSum(new int[]{1, 2, 2, 3, 3});
    }


}