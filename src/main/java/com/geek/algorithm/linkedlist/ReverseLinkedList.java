package com.geek.algorithm.linkedlist;

import java.util.Stack;

/**
 * @author lucas.zhao
 * @date 2023/07/30 23:43
 * @email jczhao_cs@163.com
 */

/**
 * 反转链表
 * https://leetcode.cn/problems/reverse-linked-list
 * 标签：双指针、递归算法
 *
 * 解题思路
 *  1.双指针迭代
 *  2.递归实现
 */
public class ReverseLinkedList {

    public ListNode reverseList4(ListNode head) {
        // 处理特殊情况，也是递归方法的出口
        if (head == null || head.next == null) {
            return head;
        }

        // 递推过程
        ListNode p = reverseList4(head.next);

        // 回溯过程
        head.next.next = head;
        head.next = null;
        return p;
    }


    /**
     * 递归实现（链表具有天然可以实现递归的特性）
     * 分析为什么可以使用递归解决：
     *  1.大问题可以拆分成两个子问题
     *    反转单链表可以拆分成反转头结点（头结点就一个节点不需要反转） + 反转头结点以外的链表两个子问题
     *  2.子问题解决方式和大问题解决方式一样
     *  3.存在最小子问题
     *
     * 递归分为两个过程：递推过程 + 回溯过程
     *
     */
    public ListNode reverseList3(ListNode head) {
        // 1.递归终止条件
        if (head == null || head.next == null) {
            return head;
        }

        // 2.递过程
        ListNode p = reverseList3(head.next);

        // 3.归过程(反转操作)
        head.next.next = head;
        head.next = null;
        return p;
    }

    // 双指针迭代实现
    public ListNode reverseList2(ListNode head) {
        // 1.定义两个指针pre（pre指向头结点的前一个节点）和current（current指向头结点）
        ListNode pre = null;
        ListNode current = head;

        while (current != null) {
            ListNode tmp = current.next;
            // 2.将cur的next节点指向pre
            current.next = pre;
            // 3.cur节点和pre节点都向后移动
            pre = current;
            current = tmp;
        }
        return pre;
    }

    // 通过栈实现
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode list = null;
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (stack.peek() != null) {
            list = stack.pop();
            list = list.next;
        }
        return list;
    }
}
