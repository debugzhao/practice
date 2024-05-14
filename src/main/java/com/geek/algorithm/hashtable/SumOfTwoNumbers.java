package com.geek.algorithm.hashtable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lucas.zhao
 * @date 2023/07/28 12:19
 * @email jczhao_cs@163.com
 * @desc: 两数之和
 * @label: 数组、哈希表
 */
public class SumOfTwoNumbers {

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum1(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
         }
        return new int[] {0};
    }
}
