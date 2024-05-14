package com.geek.algorithm.array;

/**
 * @author lucas.zhao
 * @date 2023/08/08 12:43
 * @email jczhao_cs@163.com
 */

import java.util.Arrays;

/**
 * 合并两个有序的数组
 * https://leetcode.cn/problems/merge-sorted-array
 * 标签：数组、双指针、排序
 *
 * 解题思路：
 *  1.合并
 *  2.排序
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从nums1数组的第0个位置，拷贝到nums1的第m个位置，拷贝的长度是n
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
