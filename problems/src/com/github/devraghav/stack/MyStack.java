package com.github.devraghav.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private final Queue<Integer> queue;
    private final Queue<Integer> tempQueue;

    public MyStack() {
        queue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    public void push(int x) {
        if (queue.isEmpty())
            queue.add(x);
        else {
            while (!queue.isEmpty()) {
                tempQueue.add(queue.poll());
            }
            queue.add(x);
            while (!tempQueue.isEmpty()) {
                queue.add(tempQueue.poll());
            }
        }

    }

    public int pop() {
        if (queue.isEmpty()) return -1;
        return queue.poll();
    }

    public int top() {
        if (queue.isEmpty()) return -1;
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        System.out.println("-------------------------------");
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        System.out.println("--------------Empty-----------------");
        System.out.println(obj.queue);
    }
}
