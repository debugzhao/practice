package com.geek.algorithm.stack;

import java.util.Stack;

/**
 * @Author zhaojingchao
 * @Date 2024/05/28 09:04
 * @Email zhaojingchao@joysuch.com
 * @Desc 逆波兰表达式(后缀表达式)求值
 * https://programmercarl.com/0150.%E9%80%86%E6%B3%A2%E5%85%B0%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%B1%82%E5%80%BC.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Integer num1 = Integer.valueOf(stack.pop());
                Integer num2 = Integer.valueOf(stack.pop());
                int result = 0;
                if (token.equals("+")) {
                    result = num2 + num1;
                } else if (token.equals("-")) {
                    result = num2 - num1;
                } else if (token.equals("*")) {
                    result = num2 * num1;
                } else {
                    result = num2 / num1;
                }
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
