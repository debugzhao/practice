package com.geek.algorithm.stack;

/**
 * @author lucas.zhao
 * @date 2023/07/28 18:07
 * @email jczhao_cs@163.com
 */

import java.util.*;

/**
 * 题目：判断是否是有效的括号
 * 相关标签：栈、字符串
 * 解题思路：
 */
public class IsValidBracket {
    public static void main(String[] args) {
        String string = "[()]{}";
        System.out.println(isValid(string));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return false;
        }

        // 遇到左括号时就将它的另一半括号压入栈，遇到右括号时弹出栈顶元素判断是否相同，相同则说明匹配成功
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
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
