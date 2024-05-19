package com.geek.algorithm.linkedlist;

/**
 * @Author zhaojingchao
 * @Date 2024/05/19 12:50
 * @Email zhaojingchao@joysuch.com
 * @Desc 删除链表的倒数第 N 个结点: 快慢指针|虚拟节点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 * https://programmercarl.com/0019.%E5%88%A0%E9%99%A4%E9%93%BE%E8%A1%A8%E7%9A%84%E5%80%92%E6%95%B0%E7%AC%ACN%E4%B8%AA%E8%8A%82%E7%82%B9.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义虚拟头结点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        // 定义快慢指针
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        // 快指针先移动n+1步骤
        n++;
        while (n-- > 0 && fast != null) {
            fast = fast.next;
        }

        // 快慢指针同时移动
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 移除元素
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
