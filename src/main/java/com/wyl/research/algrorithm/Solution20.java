package com.wyl.research.algrorithm;

import java.util.*;
import java.util.stream.Collectors;

class Solution20 {

    public static void main(String[] args) {
        //int[]数组快速转换
        int[] arr1 = {};
        Integer[] integers = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        List<Integer> collect = Arrays.stream(arr1).boxed().collect(Collectors.toList());


        Integer[] arr = {1, 2, 2, 3};
        Arrays.sort(arr, Collections.reverseOrder());
    }

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Solution20() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (mappings.containsKey(s.charAt(i))) {
                Character pop = stack.empty() ? '#' : stack.pop();
                if (pop != mappings.get(s.charAt(i))) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}