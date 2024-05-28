package com.geek.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhaojingchao
 * @Date 2024/05/28 12:50
 * @Email zhaojingchao@joysuch.com
 * @Desc 递归遍历二叉树（前序、中序、后续）
 * 递归三要素：
 * 1.确定递归函数的参数和返回值
 * 2.确定递归函数的终止条件
 * 3.确定单层递归逻辑
 */
public class RecursionTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        return list;
    }


    /**
     * 前序遍历
     * @param cur
     * @param list
     */
    public void preorderTraversal(TreeNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        }
        list.add(cur.val);
        preorderTraversal(cur.left, list);
        preorderTraversal(cur.right, list);
    }

    /**
     * 中序遍历
     * @param cur
     * @param list
     */
    public void inorderTraversal(TreeNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        }
        inorderTraversal(cur.left, list);
        list.add(cur.val);
        inorderTraversal(cur.right, list);
    }

    /**
     * 后序遍历
     * @param cur
     * @param list
     */
    public void postorderTraversal(TreeNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        }
        postorderTraversal(cur.left, list);
        postorderTraversal(cur.right, list);
        list.add(cur.val);
    }
}
