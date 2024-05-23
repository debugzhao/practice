package com.geek.algorithm.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.List;

/**
 * @Author zhaojingchao
 * @Date 2024/05/23 16:40
 * @Email zhaojingchao@joysuch.com
 * @Desc  三数之和
 *
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 0, 0};
        Arrays.sort(nums);
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 先对数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 如果排序之后的第一个元素>0，直接返回
            if (nums[i] > 0) {
                return result;
            }

            // 对a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right --;
                } else if (sum < 0) {
                    left ++;
                } else { // 找到满足条件的三元组
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 对b去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left ++;
                    }
                    // 对c去重
                    while (left < right &&  nums[right] == nums[right - 1]) {
                        right --;
                    }
                    right --;
                    left ++;
                }
            }
        }
        return result;
    }
}
