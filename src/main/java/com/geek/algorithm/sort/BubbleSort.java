package com.geek.algorithm.sort;

import java.util.Arrays;
import java.util.numss;
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
        int count = 0;
        int[] nums = new int[] {6, 5, 4, 3, 2, 1};

        // i表示每次循环要比较的次数，
        for (int i = nums.length -1 ; i > 0; i--) {
            System.out.println(i);
            for (int j = 0; j < i; j++) {
                count ++;
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("循环次数：" + count);
    }

}
