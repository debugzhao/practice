package com.geek.algorithm.sort;

import java.util.Arrays;

/**
 * @Author zhaojingchao
 * @Date 2024/05/22 20:04
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[] {6, 5, 4, 3, 2, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 对数组内的元素进行排序
     * @param nums
     */
    public static void sort(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        sort(nums, lo, hi);
    }


    /**
     * 对指定区间内的元素进行排序
     */
    public static void sort(int[] nums, int lo, int hi) {
        // 安全性校验
        if (lo >= hi) {
            return;
        }

        // 需要对数组nums，lo索引到hi索引分组（分为左子组和右子组）
        int partition = partition(nums, lo, hi); // 返回的是分组的分界值所在的索引

        // 让左子组有序
        sort(nums, lo, partition -1);

        // 让右子组有序
        sort(nums, partition + 1, hi);
    }


    /**
     * 对指定区间内的元素进行分区，并返回分区界限对应的索引
     */
    public static int partition(int[] nums, int lo, int hi) {
        // 确定分界值
        int key = nums[lo];

        // 定义两个指针，分别指向待切分数组的最小索引和最大索引的下一个位置
        int left = lo;
        int right = hi + 1;

        // 切分
        while (true) {
            // 从右往左扫描，移动right指针，找到一个比分界值小的元素，停止
            while (less(key, nums[--right])) {
                 if (right == lo) {
                     break;
                 }
            }

            // 从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (less(nums[++left], key)) {
                if (left == hi) {
                    break;
                }
            }

            // 如果left >= right则扫描完毕，循环结束，如果不是则
            if (left < right) {
                exchange(nums, left, right);
            } else {
                break;
            }
        }

        // 交换分界值
        exchange(nums, lo, right);
        return right;
    }


    public static void exchange(int[] nums, int index1, int index2) {
        int temp =  nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static boolean less(int a, int b) {
        return a < b;
    }
}
