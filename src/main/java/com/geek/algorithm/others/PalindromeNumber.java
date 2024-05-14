package com.geek.algorithm.others;

/**
 * @author lucas.zhao
 * @date 2023/08/08 13:50
 * @email jczhao_cs@163.com
 */

/**
 * 回文数
 * https://leetcode.cn/problems/palindrome-number
 * 标签：数学
 *
 * 解题思路：
 *  举个例子：1221 这个数字。
 *  通过计算 1221 / 1000， 得首位1
 *  通过计算 1221 % 10， 可得末位 1
 *  进行比较
 *  再将 22 取出来继续比较
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // 判断边界问题
        if (x < 0) {
            return false;
        }

        int div = 1;
        // 计算除数
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            // 计算首位
            int left = x / div;
            // 计算末位
            int right = x % 10;
            if (left != right) {
                return false;
            }
            // x去掉首位和末位
            x = (x % div) / 10;
            // 除数缩小100背
            div /= 100;
        }
        return true;
    }
}
