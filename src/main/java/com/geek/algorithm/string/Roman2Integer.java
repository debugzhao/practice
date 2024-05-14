package com.geek.algorithm.string;

/**
 * @author lucas.zhao
 * @date 2023/08/07 14:30
 * @email jczhao_cs@163.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * https://leetcode.cn/problems/roman-to-integer/
 * 标签：哈希表、字符串、数字
 */
public class Roman2Integer {
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int value = map.get(s.charAt(i));
            // i < length -1; 目的是为了防止遍历到最后一个字符时溢出
            if (i < length -1 && value < map.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }
}
