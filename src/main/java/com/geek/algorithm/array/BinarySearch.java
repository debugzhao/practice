package com.geek.algorithm.array;

/**
 * @author lucas.zhao
 * @date 2023/08/05 11:30
 * @email jczhao_cs@163.com
 */

/**
 * 二分查找
 * https://leetcode.cn/problems/binary-search/
 * 标签：数组、二叉查找
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        // 将target定义在左闭右闭的区间内，[left, right]
        int right = nums.length - 1;
        // 当left == right时，区间[left, right]依然有效，所以使用 <=
        while (left <= right) {
            // 防止middle变量溢出，等同于(left + right) / 2
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                // 说明target在右侧区间，left需要移动以便下次在新的区间内查找
                left = middle + 1;
            } else if ((nums[middle] > target)) {
                // 说明target在左侧区间，right需要移动以便下次在新的区间内查找
                right = middle - 1;
            }
        }
        return -1;
    }
}
