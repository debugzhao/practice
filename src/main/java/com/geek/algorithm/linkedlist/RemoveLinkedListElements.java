package com.geek.algorithm.linkedlist;

/**
 * @author lucas.zhao
 * @date 2023/07/31 15:35
 * @email jczhao_cs@163.com
 */

/**
 * 删除链表中的元素
 * https://leetcode.cn/problems/remove-linked-list-elements/description/
 * 标签：递归
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        // 该节点是要删除的节点的话，则返回当前节点的下一个节点；否则直接返回当前节点
        return head.val == val ? head.next : head;
    }
}
