package com.geek.algorithm.array;

import org.w3c.dom.ls.LSInput;

import java.util.*;

/**
 * @author lucas.zhao
 * @date 2023/08/01 15:20
 * @email jczhao_cs@163.com
 */

/**
 * 只出现一次的数字
 * https://leetcode.cn/problems/single-number-ii/
 *
 * 标签：位运算
 */
public class SingleNumber {
    public static void main(String[] args) {
    }

    /**
     * 使用散列表来存储元素,元素出现的次数
     */
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer count = map.get(nums[i]);
                map.put(nums[i], ++count);
            } else {
                map.put(nums[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
