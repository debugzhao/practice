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
        int count = 0;
        int[] array = new int[] {6, 5, 4, 3, 2, 1};
        // i表示每次循环要比较的次数，
        for (int i = array.length -1 ; i > 0; i--) {
            System.out.println(i);
            for (int j = 0; j < i; j++) {
                count ++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println("循环次数：" + count);
    }

}
