package com.github.devraghav.stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> originalStack;
    private Stack<Integer> minStack;

    public MinStack() {
        originalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (originalStack.isEmpty()) {
            originalStack.push(val);
            minStack.push(val);
        } else {
            originalStack.push(val);
            minStack.push(val < minStack.peek() ? val : minStack.peek());
        }
    }

    public void pop() {
        if (originalStack.isEmpty()) return;
        originalStack.pop();
        minStack.pop();
    }

    public int top() {
        return originalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(1);
        obj.push(3);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        System.out.println("-------------------------------");
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        System.out.println("-------------------------------");
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

        obj.pop();
        System.out.println("--------------Empty-----------------");
        System.out.println(obj.originalStack);
        System.out.println(obj.minStack);
    }
}
