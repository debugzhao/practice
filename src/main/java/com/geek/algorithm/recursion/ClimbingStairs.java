package com.geek.algorithm.recursion;

/**
 * @author lucas.zhao
 * @date 2023/07/31 22:48
 * @email jczhao_cs@163.com
 */

/**
 * 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/
 * 标签：数学归纳、动态规划、递归
 *
 * 解题思路：
 *  1.数学归纳
 *    通过数学归纳可知 f(n) = f(n-1) + f(n-2)
 *  2.动态规划
 *
 */
public class ClimbingStairs {

    /**
     * @param n 楼梯阶数
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//        System.out.println(climbStairs(45));
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime);

//        int fib = new ClimbingStairs().fib(45);
    }

    public int fib(int n) {
        // 带备忘录的递归，初始化全为0
        int[] memo = new int[n + 1];
        return recursion(memo, n);
    }

    int recursion(int[] memo, int n){
        // base case
        if (n ==1 || n ==2) {
            return 1;
        }
        // 备忘录已经存储该值，不需要递归直接返回即可
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = recursion(memo, n-1) + recursion(memo, n -2);
        return memo[n];
    }
}
