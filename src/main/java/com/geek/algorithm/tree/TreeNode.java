package com.geek.algorithm.tree;

/**
 * @Author zhaojingchao
 * @Date 2024/05/28 12:43
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
