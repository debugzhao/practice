package com.geek.algorithm.array;

/**
 * @author lucas.zhao
 * @date 2023/08/07 15:15
 * @email jczhao_cs@163.com
 */

/**
 * 动态和
 * https://leetcode.cn/problems/running-sum-of-1d-array/
 * 标签：数组、前缀和
 *
 *
 */
public class DynamicSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        runningSum(nums);
    }

    public static int[] runningSum(int[] nums) {
        int[] array = new int[nums.length];
        int tmpSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tmpSum += nums[i];
            array[i] = tmpSum;
        }
        return array;
    }
}
