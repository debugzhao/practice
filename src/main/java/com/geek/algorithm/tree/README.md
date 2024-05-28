# 二叉树理论基础

#### 种类

1. 满二叉树

2. 完全二叉树

   最底层从左到右是连续的

3. 二叉搜索树

   节点的元素值是有顺序的，搜索的时间复杂度log(n)

   顺序：所有的左子树值都 < 父节点，所有的右子树值都 > 父节点

4. 平衡二叉搜索树

   左子树和右子树的高度差不能超过1

#### 存储方式

1. 链式存储

   通过left指针、right指针实现

2. 顺序存储

   通过数组实现

#### 遍历方式

1. 深度优先遍历（递归实现）
   1. 前序遍历
   2. 中序遍历
   3. 后续遍历
2. 广度优先遍历
   1. 层序遍历

#### 定义方式

```java
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
```

