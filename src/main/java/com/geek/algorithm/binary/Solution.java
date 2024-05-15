package com.geek.algorithm.binary;

/**
 * @Author zhaojingchao
 * @Date 2024/05/15 23:18
 * @Email zhaojingchao@joysuch.com
 * @Desc 数组二分查找 https://leetcode.cn/problems/binary-search/
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 左闭右闭区间
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
