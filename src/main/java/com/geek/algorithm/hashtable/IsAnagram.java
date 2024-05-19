package com.geek.algorithm.hashtable;

/**
 * @Author zhaojingchao
 * @Date 2024/05/19 17:59
 * @Email zhaojingchao@joysuch.com
 * @Desc 有效的字母异位词：哈希表
 * https://leetcode.cn/problems/valid-anagram/description/
 * https://programmercarl.com/0242.%E6%9C%89%E6%95%88%E7%9A%84%E5%AD%97%E6%AF%8D%E5%BC%82%E4%BD%8D%E8%AF%8D.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hashtable = new int[26];
        for (int i = 0; i < t.length(); i++) {
            hashtable[s.charAt(i) - 'a']++;
            hashtable[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hashtable[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
