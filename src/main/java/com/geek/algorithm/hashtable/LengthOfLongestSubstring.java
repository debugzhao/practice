package com.geek.algorithm.hashtable;

/**
 * @author lucas.zhao
 * @date 2023/07/28 14:30
 * @email jczhao_cs@163.com
 * @desc: 无重复字符的最长子串
 * @label: 字符串、哈希表、滑动窗口
 */


import java.util.HashMap;

/**
 * 题目：无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 相关标签：字符串、哈希表、滑动窗口
 *
 * 解题思路：
 * 1."重复字符"
 *  看到"重复字符"关键字，就需要判断字符出现的次数。
 *  一旦需要判断重复次数，就会用到散列表数据结构。
 *  其中key表示具体的字符，value表示重复次数
 * 2."子串"
 *  可以通过滑动窗口来实现动态扩展、收缩子串
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String string = "abba";
        int maxLength = lengthOfLongestSubstring1(string);
        System.out.println(maxLength);
    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int max = 0;
        // 定义一个map，用来存储每一个字符的下标
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                // 返回上一个重复字符的下一个位置
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String string) {
        // 散列表记录字符出现的位置
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // 用于记录最大不重复子串的长度
        int maxLength = 0;
        // 滑动窗口左指针
        int left = 0;

        for (int i = 0; i < string.length(); i++) {
            // 1.首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）
            if (map.containsKey(string.charAt(i))) {
                left = Math.max(left, map.get(string.charAt(i)) + 1);
            }
            // 2.无论是否更新left，都需要更新string.charAt(i)的位置
            map.put(string.charAt(i), i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
