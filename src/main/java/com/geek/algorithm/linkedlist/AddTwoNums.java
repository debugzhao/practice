package com.geek.algorithm.linkedlist;

/**
 * @author lucas.zhao
 * @date 2023/08/03 18:22
 * @email jczhao_cs@163.com
 */

/**
 * 两数相加
 * https://leetcode.cn/problems/add-two-numbers/description/
 * 标签：链表、数学经验
 *
 * 解题思路：
 *  1.从链表的最低有效位开始逐位相加
 *  2.在相加过程中需要使用额外变量跟踪进位
 * 注意事项：
 *  1.需要考虑两个链表长度不一样的情况
 *  2.当链表最后一个有效位相加时，如果有进位则需要新创建一个node保存这个进位
 */
public class AddTwoNums {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        // 进位
        int carry = 0;
        // 只要l1或者l2 有一个不为null，则就继续循环下去
        while (l1 != null || l2 != null) {
            // 处理l1、l2链表长度不一样长的情况
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            if (head == null) {
                // 第一次按位加，需要初始化头结点、尾结点
                head = tail = new ListNode(sum % 10);
            } else {
                // 后面再次按位加，需要改变尾结点的指向
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            // l1、l2向后移动
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            // 计算是否进位
            carry = sum / 10;
        }

        // 链表最后一个有效位相加时有进位
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
