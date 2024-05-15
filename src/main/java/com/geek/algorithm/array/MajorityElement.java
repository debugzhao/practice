package com.geek.algorithm.array;

/**
 * @author lucas.zhao
 * @date 2023/08/01 15:54
 * @email jczhao_cs@163.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 * https://leetcode.cn/problems/majority-element/
 *
 *
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                result = entry.getKey();
            }
        }
        return result;
    }

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
    public static class RemoveElement {
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
}
