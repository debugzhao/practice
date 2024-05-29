package com.geek.algorithm.tree;

/**
 * @Author zhaojingchao
 * @Date 2024/05/29 10:27
 * @Email zhaojingchao@joysuch.com
 * @Desc 翻转二叉树
 * https://programmercarl.com/0226.%E7%BF%BB%E8%BD%AC%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root); // 中
        invertTree(root.left);  // 左
        invertTree(root.right); // 右
        return root;
    }

    public void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
