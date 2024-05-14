package com.geek.algorithm.array;

/**
 * @author lucas.zhao
 * @date 2023/08/29 14:42
 * @email jczhao_cs@163.com
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * https://leetcode.cn/problems/pascals-triangle/description/
 * 标签：数字、动态规划
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i -1) {
                    list.add(1);
                } else {
                    list.add(results.get(i -1).get(j -1) + results.get(i - 1).get(j));
                }
            }
            results.add(list);
        }
        return results;
    }
}
