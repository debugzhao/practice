package com.geek.algorithm.sort;

import java.util.Arrays;

/**
 * @Author zhaojingchao
 * @Date 2024/05/22 19:22
 * @Email zhaojingchao@joysuch.com
 * @Desc 插入排序：想象打扑克插入牌的场景
 * 将数组分为两个数组：一个是已排序的数组，一个是待排序的数组，
 * 从待排序的数组的最左侧选择一个元素a 和已排序数组的最右侧元素进行比较b
 * 如果a < b，则交换元素位置，依次循环交换
 * https://www.bilibili.com/video/BV1T7411f7b9?p=8&vd_source=f3478dde6c64ccf1e4a7d6ed91877d4b
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[] {6, 5, 4, 3, 2, 1};
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    // 交换元素位置
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
