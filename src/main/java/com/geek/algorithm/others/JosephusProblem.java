package com.geek.algorithm.others;

/**
 * @author lucas.zhao
 * @date 2023/07/31 16:59
 * @email jczhao_cs@163.com
 */

/**
 * 圆圈中最后剩下的数字(约瑟夫问题)
 * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/description/
 * 标签：数学归纳法
 */
public class JosephusProblem {
    public int lastRemaining(int n, int m) {
        // 最终活下来的那个人的初始位置
        int pos = 0;

        // 最后一轮剩下两个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            // 每次循环右移
            pos = (pos + m) % i;
        }
        return pos;
    }
}
