package com.geek.algorithm.linkedlist;

/**
 * @author lucas.zhao
 * @date 2023/07/30 15:06
 * @email jczhao_cs@163.com
 */

import com.geek.algorithm.linkedlist.ListNode;

/**
 * 删除链表中的节点
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof
 *
 * 解题思路：
 *  删除值为value的节点只需要两个步骤
 *  1.定位元素
 *  2.修改引用
 *  3.特殊情况
 *    3.1 头结点正好是要删除的元素
 *    3.2 链表中没有要删除的元素
 */
public class DeleteLinkedListNode {

    public static ListNode deleteNode(ListNode head, int val) {
        // 如果头结点正好是要被删除的元素，则直接返回head.next
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode current = head.next;
        // 一直遍历，找到要被删除的节点
        while (current != null && current.val != val) {
            pre = current;
            current = current.next;
        }

        // 删除节点
        // 如果current为null，说明链表不包含要被删除的节点
        if (current != null) {
            pre.next = current.next;
        }
        return head;
    }
}

