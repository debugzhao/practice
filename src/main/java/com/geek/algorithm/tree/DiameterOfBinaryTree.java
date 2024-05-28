package com.geek.algorithm.tree;

/**
 * @author lucas.zhao
 * @date 2023/07/30 13:54
 * @email jczhao_cs@163.com
 */

/**
 * 计算二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/solutions/?company_slug=xiaohongshu
 *
 * 直径长度定义：树中任意两个节点最短路径的最大值
 * 两个节点之间路径长度：他们之间边的数目
 *
 * 解题思路：
 *  1.如何求得两个叶子节点之间的路径长度
 *    两个叶子节点之间的路径长度：根节点到两个叶子节点之间的路径长度
 *    1.1 深度优先搜索
 *      通过深度优先搜索算法(大多数是通过递归算法实现的)来计算root节点到某一个节点之间的深度
 *      递归算法三要素：子问题与原问题做同样的事情、一个让递归结束的出口、递归表达式
 */
public class DiameterOfBinaryTree {
    private int max;
    public static void main(String[] args) {

    }

    /**
     * 计算某一个节点的路径长度
     */
    public int depth(TreeNode node) {
        // 递归函数出口
        if (node == null) {
            return 0;
        }
        int left, right;
        // 计算左子结点的深度
        left = depth(node.left);
        // 计算右子结点的深度
        right = depth(node.right);

        // 每次递归都需要计算一次
        if (left + right > max) {
            // 如果当前找到更大的就替换max
            max = left + right;
        }
        return Math.max(left, right) + 1;
    }
}

