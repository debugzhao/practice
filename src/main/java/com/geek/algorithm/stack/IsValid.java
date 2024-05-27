package com.geek.algorithm.stack;

import java.util.Stack;

/**
 * @Author zhaojingchao
 * @Date 2024/05/27 15:53
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class IsValid {
    public boolean isValid(String s) {
        // 剪枝操作
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }
}
