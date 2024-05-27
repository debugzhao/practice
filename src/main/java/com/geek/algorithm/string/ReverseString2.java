package com.geek.algorithm.string;

/**
 * @Author zhaojingchao
 * @Date 2024/05/23 19:03
 * @Email zhaojingchao@joysuch.com
 * @Desc 反转字符串
 * https://programmercarl.com/0541.%E5%8F%8D%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2II.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 */
public class ReverseString2 {
    public String reverseStr(String s, int k) {
        char[] nums = s.toCharArray();
        // 每次循环i的步长为2k
        for (int i = 0; i < nums.length; i += 2 * k) {
            if (i + k <= nums.length) {
                reverse(nums, i, i + k - 1);
            } else {
                reverse(nums, i, nums.length - 1);
            }
        }
        return String.valueOf(nums);
    }

    // 反转字符串
    public void reverse(char[] nums, int lo, int hi) {
        for (int i = lo, j = hi; i < j; i++, j--) {
            char temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
