 package com.geek.algorithm.tree;

/**
 * @author lucas.zhao
 * @date 2023/08/02 11:38
 * @email jczhao_cs@163.com
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序遍历
 * https://leetcode.cn/problems/binary-tree-postorder-traversal
 * 标签：二叉树、栈迭代、递归
 *
 * 解题思路：
 *  1.利用栈实现二叉树的后序遍历
 *    二叉树的后序遍历和前序遍历有一定的相关性，因此可以考虑在前序遍历的基础上做改动
 *    前序遍历：根节点 -> 左子结点 -> 右子节点
 *    变换之后的前序遍历：根节点 -> 右子结点 -> 左子节点
 *    将上面的结果反转就是需要的后续遍历：左子结点 -> 右子节点 -> 根节点
 *  2.递归实现后序遍历
 */
public class PostorderTraversal {
    /**
     * 利用递归实现二叉树后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        recursion(root, list);
        return list;
    }


    /**
     * 为什么二叉树前序遍历可以用递归实现？
     * 1.大问题可以拆分成子问题
     *   遍历一棵树可以拆分成遍历该树的左子树、右子树
     * 2.子问题求解方式和大问题求解方式一样
     *   遍历左子树、右子树的解决方式和遍历整颗树的解决方式一样
     * 3.存在最小子问题
     *   当遍历到叶子节点时就不会再拆分左子树、右子树，所以存在最小子问题
     */
    public void recursion(TreeNode node, ArrayList<Integer> list) {
        // 递归方法出口
        if (node == null) {
            return;
        }

        // 递推、回溯过程
        recursion(node.left, list);
        recursion(node.right, list);
        list.add(node.val);
    }

    /**
     * 二叉树后序遍历
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        // 翻转list
        Collections.reverse(list);
        return list;
    }
}
