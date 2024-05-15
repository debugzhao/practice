package com.geek.algorithm.array;

/**
 * @Author zhaojingchao
 * @Date 2024/05/16 00:20
 * @Email zhaojingchao@joysuch.com
 * @Desc 有序数组的平方：数组|双指针|排序
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 * https://www.bilibili.com/video/BV1QB4y1D7ep/?spm_id_from=333.788&vd_source=f3478dde6c64ccf1e4a7d6ed91877d4b
 */
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        // i 代表慢指针
        // j 代表快指针
        for(int i = 0, j = nums.length - 1; i <= j; ) {
            // 快指针和慢指针的移动操作是需要满足一定条件才能执行的，所以不能直接在for语句()中执行
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[k--] = nums[i] * nums[i];
                i ++;
            } else {
                result[k--] = nums[j] * nums[j];
                j --;
            }
        }
        return result;
    }
}
