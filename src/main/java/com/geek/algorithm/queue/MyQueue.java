package com.geek.algorithm.queue;

import java.util.Stack;

/**
 * @Author zhaojingchao
 * @Date 2024/05/27 13:59
 * @Email zhaojingchao@joysuch.com
 * @Desc  用栈实现队列
 * https://programmercarl.com/0232.%E7%94%A8%E6%A0%88%E5%AE%9E%E7%8E%B0%E9%98%9F%E5%88%97.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
 */
public class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
         stackIn.push(x);
    }

    public int pop() {
        if (!stackOut.empty()) {
            return stackOut.pop();
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        return stackOut.pop();
    }

    public int peek() {
        int result = this.pop();
        stackOut.push(result);
        return result;
    }


    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }
}
