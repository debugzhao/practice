package com.geek.algorithm.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author zhaojingchao
 * @Date 2024/05/27 14:19
 * @Email zhaojingchao@joysuch.com
 * @Desc 用队列模拟栈
 */
public class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void print() {
        System.out.println(queue);
    }

    public void push(int x) {
        queue.add(x);
        for(int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.print();
    }
}
