package com.geek.algorithm.array;

/**
 * @Author zhaojingchao
 * @Date 2024/05/16 08:29
 * @Email zhaojingchao@joysuch.com
 * @Desc 长度最小的子数组：滑动窗口
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 * https://www.bilibili.com/video/BV1tZ4y1q7XE/?p=4&spm_id_from=pageDriver
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口起始位置
        int left = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        // right表示滑动窗口终止位置
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, (right - left + 1));
                sum -= nums[left];
                left ++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
