package com.geek.algorithm.linkedlist;

/**
 * @Author zhaojingchao
 * @Date 2024/05/16 10:15
 * @Email zhaojingchao@joysuch.com
 * @Desc 移除链表指定元素: 链表
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * https://www.bilibili.com/video/BV18B4y1s7R9/?spm_id_from=333.788&vd_source=f3478dde6c64ccf1e4a7d6ed91877d4b
 */
public class RemoveElements {

    /**
     * 原链表删除元素
     */
    public ListNode removeElements1(ListNode head, int val) {
        // 判断头结点是否是要删除的值
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 使用虚拟节点删除元素，目的是统一对链表操作，不需要进行额外判断是否是头结点
     */
    public ListNode removeElements2(ListNode head, int val) {
        // 声明一个虚拟头结点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode current = dummyHead;
        // 我们要删除的节点是current.next节点
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummyHead.next;
    }
}
