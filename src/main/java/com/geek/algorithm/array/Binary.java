package com.geek.algorithm.array;

/**
 * @Author zhaojingchao
 * @Date 2024/05/15 23:18
 * @Email zhaojingchao@joysuch.com
 * @Desc 数组二分查找 https://leetcode.cn/problems/binary-search/
 * https://www.bilibili.com/video/BV1fA4y1o715/?spm_id_from=333.788&vd_source=f3478dde6c64ccf1e4a7d6ed91877d4b
 */
public class Binary {
    public static void main(String[] args) {

    }

    /**
     * 左闭右闭区间写法 [1, 9]
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


    /**
     * 左闭右开区间写法 [1, 9)
     */
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
