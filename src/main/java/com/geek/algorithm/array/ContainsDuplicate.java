package com.geek.algorithm.array;

/**
 * @author lucas.zhao
 * @date 2023/08/05 11:47
 * @email jczhao_cs@163.com
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * https://leetcode.cn/problems/contains-duplicate/
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
