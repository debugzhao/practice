package com.geek.algorithm.binary;

/**
 * @Author zhaojingchao
 * @Date 2024/05/15 23:41
 * @Email zhaojingchao@joysuch.com
 * @Desc 移除元素：数组、双指针
 * https://leetcode.cn/problems/remove-element/description/
 * https://www.bilibili.com/video/BV12A4y1Z7LP/?spm_id_from=333.788&vd_source=f3478dde6c64ccf1e4a7d6ed91877d4b
 *
 * 快慢指针实现：
 * 快指针：寻找新数组所需要的元素
 * 慢指针：新数组的下标值
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 慢指针：新数组的下标值
        int slow = 0;
        // 快指针：寻找新数组所需要的元素
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                // 寻找到新数组所需要的元素，进行覆盖操作
                nums[slow] = nums[fast];
                slow ++;
            }
        }
        return slow;
    }
}
