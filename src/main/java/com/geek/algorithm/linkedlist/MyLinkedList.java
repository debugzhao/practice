package com.geek.algorithm.linkedlist;


/**
 * @Author zhaojingchao
 * @Date 2024/05/16 10:59
 * @Email zhaojingchao@joysuch.com
 * @Desc 设计链表
 * https://leetcode.cn/problems/design-linked-list/
 * https://www.bilibili.com/video/BV1FU4y1X7WD/?spm_id_from=333.788&vd_source=f3478dde6c64ccf1e4a7d6ed91877d4b
 */
public class MyLinkedList {
    // 链表容量
    int size;
    // 虚拟头结点
    ListNode dummyHead;
    public MyLinkedList() {
        size = 0;
        dummyHead = new ListNode(0);
    }

    /**
     * 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index > size) {
            return -1;
        }

        ListNode current = dummyHead;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        size ++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode current = dummyHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size ++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode newNode = new ListNode(val);
        ListNode current = dummyHead;
        while (index > 0) {
            current = current.next;
            index --;
        }
        newNode.next = current.next;
        current.next = newNode;
        size ++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        
        ListNode current = dummyHead;
        while (index > 0) {
            current = current.next;
            index --;
        }
        current.next = current.next.next;
        size --;
    }
}
