package com.geek.algorithm.tree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author zhaojingchao
 * @Date 2024/05/28 17:43
 * @Email zhaojingchao@joysuch.com
 * @Desc 二叉树非递归遍历
 */
public class IterationTraversal {

    /**
     * 前序遍历顺序：中 -> 左 -> 右
     * 入栈顺序：中 -> 右 -> 左
     * 出栈顺序：中 -> 左 -> 右
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 先放根节点
        stack.push(root);
        while (!stack.isEmpty()) {
            list.add(stack.pop().val);
            // 入栈顺序：中 右 左
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return list;
    }


    /**
     * 后序遍历是在前序遍历的基础之上实现的
     * 入栈顺序：中 -> 左 -> 右
     * 出栈顺序：中 -> 右 -> 左
     * 反转顺序：左 -> 右 -> 中
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 先放根节点
        stack.push(root);
        while (!stack.isEmpty()) {
            list.add(stack.pop().val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        Collections.reverse(list);
        return list;
    }


    /**
     * 中序遍历：栈中记录的是指针访问过的元素
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode cur = root;
        // 栈中记录的是cur指针访问过的元素
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left; // 左
            } else {
                cur = stack.pop(); // 中
                list.add(cur.val);
                cur = cur.right; // 右
            }
        }
        return list;
    }

}
