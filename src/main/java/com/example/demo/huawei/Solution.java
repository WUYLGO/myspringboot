package com.example.demo.huawei;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Solution {
    public static void main(String[] args) throws IOException {
        int[][] arr = {{1, 4}, {2, 5}, {8, 9}};
        int[][] merge = merge(arr);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[i].length; j++) {
                System.out.println(merge[i][j]);
            }
        }
    }

    public static int[][] merge(int[][] nums) {
        if (nums.length == 0) {
            return new int[0][0];
        }
        int[][] result = new int[nums.length][2];
        Arrays.sort(nums, (v1, v2) -> v1[0] - v2[0]);
        result[0] = nums[0];
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (result[j][1] >= nums[i][0]) {
                result[j][1] = Math.max(result[j][1], nums[i][1]);
            } else {
                j++;
                result[j] = nums[i];
            }
        }
        return Arrays.copyOf(result, j + 1);

    }


}