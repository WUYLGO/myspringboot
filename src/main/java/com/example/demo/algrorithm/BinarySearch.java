package com.example.demo.algrorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 9;
        int i = binarySearch(arr, target);
        System.out.println("目标位置为:===>" + i+"号位置");

    }

    public static int binarySearch(int[] arr, int target) {
        int length = arr.length;
        //左起点
        int l = 0;
        //右起点
        int r = length - 1;

        while (l <= r) {
            //找中点
            int mid = (r - l) / 2 + l;

            //比较中值
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                //中值小于目标值,收紧左边
                l = mid + 1;
            } else if (arr[mid] > target) {
                //中值大于目标值,收紧右边
                r = mid - 1;
            }
        }
        return -1;
    }

}
