package com.geek.algorithm.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

/**
 * @Author zhaojingchao
 * @Date 2024/05/22 18:36
 * @Email zhaojingchao@joysuch.com
 * @Desc 冒泡排序
 * https://www.bilibili.com/video/BV1T7411f7b9?p=2&vd_source=f3478dde6c64ccf1e4a7d6ed91877d4b
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[] {6, 5, 4, 3, 2, 1};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        for(int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换元素
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
