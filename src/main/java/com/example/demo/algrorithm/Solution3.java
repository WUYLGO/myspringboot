package com.example.demo.algrorithm;

import java.util.HashSet;
import java.util.Set;


/**
 * @Description: 3. 无重复字符的最长子串
 * @Date: 2020/5/1 11:56
 * @Idea: 使用set对单个字符去重:滑动窗口计算方式,双指针;
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, j - i);

            } else {
                set.remove(i);
                i++;
            }

        }
        return res;

    }
}

