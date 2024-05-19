package com.geek.algorithm.linkedlist;

/**
 * @Author zhaojingchao
 * @Date 2024/05/19 13:23
 * @Email zhaojingchao@joysuch.com
 * @Desc 环形链表:快慢指针
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * https://programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#%E6%80%9D%E8%B7%AF
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            // 快指针移动两步
            fast = fast.next.next;
            // 慢指针移动一步
            slow = slow.next;

            if (fast == slow) { // 说明找到了环
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) { // 开始寻找环入口
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
