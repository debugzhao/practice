package com.geek.algorithm.tree;

/**
 * @author lucas.zhao
 * @date 2023/08/01 11:43
 * @email jczhao_cs@163.com
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * 标签：深度优先搜索、广度优先搜索
 */
public class MaxDepth {

    /**
     * BFS 广度优先搜索
     * 遍历树的每一层节点，遍历的层数就是树的最大深度
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // BFS层次遍历思想，记录二叉树的层数
        Queue<TreeNode> queue = new LinkedList<>();
        int maxDepth = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            maxDepth ++;
            int size = queue.size();
            // 遍历每一层的左子节点、右子节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return maxDepth;
    }

    /**
     * 通过递归方式实现DFS深度优先搜索
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) +1;
    }
}
