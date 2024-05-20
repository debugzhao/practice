package com.geek.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhaojingchao
 * @Date 2024/05/20 10:37
 * @Email zhaojingchao@joysuch.com
 * @Desc 4数相加：哈希表
 * https://leetcode.cn/problems/4sum-ii/
 * https://programmercarl.com/0454.%E5%9B%9B%E6%95%B0%E7%9B%B8%E5%8A%A0II.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
 */
public class FourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        // 先遍历nums1和nums2数组，进行预处理
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                } else {
                    Integer tempCount = map.get(sum);
                    map.put(sum, ++tempCount);
                }
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int tempSum = i + j;
                Integer value = map.get(-tempSum);
                if (value != null) {
                    count += value;
                }
            }
        }
        return count;
    }

}
