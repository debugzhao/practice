package com.geek.algorithm.string;

/**
 * @Author zhaojingchao
 * @Date 2024/05/23 17:54
 * @Email zhaojingchao@joysuch.com
 * @Desc 反转字符串：双指针
 * https://programmercarl.com/0344.%E5%8F%8D%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2.html#%E6%80%9D%E8%B7%AF
 */
public class ReverseString1 {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length -1; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
