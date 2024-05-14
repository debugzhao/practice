package com.geek.algorithm.tree;

/**
 * @author lucas.zhao
 * @date 2023/08/03 11:52
 * @email jczhao_cs@163.com
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal
 * 标签：递归、广度优先遍历
 *
 * 解题思路：
 *  1.递归
 *
 *  2.广度优先遍历
 *    一旦出现树的层次遍历，都可以使用队列作为辅助结构
 */
public class LevelOrderTraversal {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return results;
        }
        // 从第0层（根节点）开始递归
        recursion(root, 0);
        return results;
    }

    /**
     * 递归实现层序遍历
     */
    public void recursion(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        // 为当前第level层创建一个数组，存储元素
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(node.val);

        // 递归，层次+1
        if (node.left != null) {
            recursion(node.left, level + 1);
        }
        if (node.right != null) {
            recursion(node.right, level + 1);
        }
    }

}
