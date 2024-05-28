package com.geek.algorithm.stack;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Stack;

/**
 * @Author zhaojingchao
 * @Date 2024/05/27 16:31
 * @Email zhaojingchao@joysuch.com
 * @Desc 删除字符串中所有相邻重复元素
 * https://programmercarl.com/1047.%E5%88%A0%E9%99%A4%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B8%AD%E7%9A%84%E6%89%80%E6%9C%89%E7%9B%B8%E9%82%BB%E9%87%8D%E5%A4%8D%E9%A1%B9.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 */
public class RemoveDuplicates {

    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (top >= 0 || result.charAt(top) == c) {
                result.deleteCharAt(top);
                top--;
            } else {
                result.append(c);
                top++;
            }
        }
        return result.toString();
    }
}
