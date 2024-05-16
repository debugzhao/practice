package com.geek.algorithm.array;

/**
 * @Author zhaojingchao
 * @Date 2024/05/16 09:38
 * @Email zhaojingchao@joysuch.com
 * @Desc 螺旋矩阵：矩阵|模拟过程
 * https://leetcode.cn/problems/spiral-matrix-ii/
 * https://www.bilibili.com/video/BV1SL4y1N7mV/?spm_id_from=333.788&vd_source=f3478dde6c64ccf1e4a7d6ed91877d4b
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0; // 每圈的起始位置
        int i = 0, j = 0; // 第i行，第j列
        int offset = 1; // 偏移量
        int loop = 1; // 记录当前循环的圈数
        int count = 1; // 矩阵需要填写的数字
        while (loop <= n / 2) {
            // 矩阵顶部
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }
            // 矩阵右列
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }
            // 矩阵底部
            for (; j > startY; j --) {
                nums[i][j] = count++;
            }
            // 矩阵左列
            for(; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX ++;
            startY ++;
            offset ++;
            loop ++;
        }

        // n是奇数
        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }
        return nums;
    }
}
