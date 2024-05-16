package com.geek.algorithm.linkedlist;

/**
 * @author lucas.zhao
 * @date 2023/07/29 18:11
 * @email jczhao_cs@163.com
 */

import java.util.HashSet;

/**
 * 环形链表（判断链表是否有环）
 * https://leetcode.cn/problems/linked-list-cycle/?company_slug=xiaohongshu
 * 相关标签：链表、双指针、哈希表
 *
 * 解题思路：
 *  1.哈希表方式
 *    1.1 如果链表有环，那么遍历这个链表，某个节点会被遍历两次
 *    1.2 具体我们可以使用哈希表来存储已经访问过的节点
 *    1.3 如果一个节点已经在哈希表中，则说明该链表有环，否则将该节点添加进哈希表
 *  2.快慢指针方式
 *    2.1 慢指针每次移动一个节点
 *    2.2 快指针每次移动两个节点
 *    2.3 如果链表中有环，则经过一定的遍历次数快慢指针会相遇
 *    2.4 为什么快慢指针一定会在环内相遇？
 */
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    // 通过哈希表方式判断链表是否有环
    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (!hashSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 通过快慢指针方式判断哈希表是否有环
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slower = head;
        ListNode faster = head;
        while (faster.next != null && faster.next.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) {
                return true;
            }
        }
        return false;
    }
}
