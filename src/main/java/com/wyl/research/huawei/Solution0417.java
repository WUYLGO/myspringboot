package com.wyl.research.huawei;

import java.util.Stack;

public class Solution0417 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Solution0417() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public synchronized void push(Integer t) {
        if (minStack.isEmpty() || minStack.peek() >= t) {
            minStack.add(t);
        } else {
            minStack.add(minStack.peek());
        }
        stack.add(t);
    }

    public synchronized void pop() {
        if (!stack.isEmpty()) {
            minStack.pop();
            stack.pop();
        }
    }

    public synchronized Integer top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }

    public synchronized Integer getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }

}
