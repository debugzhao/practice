package com.geek.algorithm.array;

/**
 * @author lucas.zhao
 * @date 2023/08/08 13:27
 * @email jczhao_cs@163.com
 */

/**
 * 移除元素
 * https://leetcode.cn/problems/remove-element
 * 标签：数组、快慢指针
 *
 * 解题思路：
 *   数组的元素在内存地址中是连续的，不能单独删除数组中的某一个元素，只能覆盖其中的元素
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        // 慢指针slowIndex，区间[0, slowIndex)内的元素为值不等于val的元素
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            // 快指针指向的元素不等于val
            if (nums[fastIndex] != val) {
                // 将其值赋值给慢指针所在的位置
                nums[slowIndex] = nums[fastIndex];
                // 赋值完毕后，慢指针右移一位，等待下一次赋值
                slowIndex ++;
            }
        }
        return slowIndex;
    }
}
