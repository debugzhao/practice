package com.geek.algorithm.array;

/**
 * @author lucas.zhao
 * @date 2023/08/01 15:54
 * @email jczhao_cs@163.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 * https://leetcode.cn/problems/majority-element/
 *
 *
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                result = entry.getKey();
            }
        }
        return result;
    }
}
