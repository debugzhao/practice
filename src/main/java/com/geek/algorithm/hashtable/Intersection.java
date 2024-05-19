package com.geek.algorithm.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author zhaojingchao
 * @Date 2024/05/19 18:23
 * @Email zhaojingchao@joysuch.com
 * @Desc 两个数组的交集:哈希表、set集合
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 * https://programmercarl.com/0349.%E4%B8%A4%E4%B8%AA%E6%95%B0%E7%BB%84%E7%9A%84%E4%BA%A4%E9%9B%86.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 */
public class Intersection {


    /**
     * 通过set集合解决
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        int[] resultArray = new int[result.size()];
        int index = 0;
        for (Integer i : result) {
            resultArray[index++] = i;
        }
        return resultArray;
        // return result.stream().mapToInt(x -> x).toArray();
    }
}
