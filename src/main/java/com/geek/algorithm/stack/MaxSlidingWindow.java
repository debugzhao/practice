package com.geek.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author zhaojingchao
 * @Date 2024/05/28 11:33
 * @Email zhaojingchao@joysuch.com
 * @Desc 滑动窗口最大值
 * https://programmercarl.com/0239.%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%9C%80%E5%A4%A7%E5%80%BC.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 * https://www.bilibili.com/video/BV1bM411X72E/?vd_source=f3478dde6c64ccf1e4a7d6ed91877d4b
 *
 */
public class MaxSlidingWindow {


    // 利用双端队列手动实现单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        // 双端队列
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 1 入队
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                // 保持队列单调性
                queue.removeLast();
            }
            queue.addLast(i);
            // 2 出队
            if (i - queue.getFirst() >= k) {
                queue.removeFirst();
            }
            // 3 保存结果
            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return result;
    }
}
