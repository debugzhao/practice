package com.geek.algorithm.tree;

/**
 * @author lucas.zhao
 * @date 2023/08/02 11:09
 * @email jczhao_cs@163.com
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 * https://leetcode.cn/problems/binary-tree-inorder-traversal
 * 标签：二叉树、栈遍历、递归
 *
 * 解题思路：
 *  1.通过栈实现中序遍历
 *  2.递归
 */
public class InorderTraversal {

    /**
     * 递归实现中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        recursion(root, list);
        return list;
    }

    public void recursion(TreeNode node, ArrayList<Integer> list) {
        // 递归方法出口
        if (node == null) {
            return;
        }
        // 递推、回溯过程
        recursion(node.left, list);
        list.add(node.val);
        recursion(node.right, list);
    }

    /**
     * 通过栈实现中序遍历
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        // 开始遍历二叉树，遍历结束条件为：stack为空并且current为null
        while (current != null || !stack.isEmpty()) {
            // 循环找到一个节点的最左子节点
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode node = stack.pop();
            list.add(node.val);

            // 当前子树的右子节点
            current = node.right;
        }
        return list;
    }
}
