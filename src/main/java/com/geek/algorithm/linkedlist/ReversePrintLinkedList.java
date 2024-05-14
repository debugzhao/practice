package com.geek.algorithm.linkedlist;

/**
 * @author lucas.zhao
 * @date 2023/07/31 12:00
 * @email jczhao_cs@163.com
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 反向打印链表(从尾到头打印链表)
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 标签：递归、双指针
 *
 * 解题思路：
 *
 */
public class ReversePrintLinkedList {

    List<Integer> list = new ArrayList<>();

    /**
     * 通过栈实现反向打印链表
     */
    public int[] reversePrint1(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        // 压栈
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] array = new int[stack.size()];
        // 出栈
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        return array;
    }

    /**
     * 通过递归实现
     */
    public int[] reversePrint(ListNode head) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    // 递归获取链表尾部元素
    public void recursion(ListNode head) {
        // 1.递归终止条件
        if (head == null ) {
            return;
        }
        // 递过程
        recursion(head.next);
        // 归过程
        list.add(head.val);
    }
}
