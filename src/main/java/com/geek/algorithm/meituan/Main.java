package com.geek.algorithm.meituan;

/**
 * @author lucas.zhao
 * @date 2023/09/19 19:04
 * @email jczhao_cs@163.com
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        // 创建测试链表
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);

        // 相减
        ListNode result = subtractTwoNumbers(l1, l2);

        // 打印结果
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
    }

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        // 哑节点，用于指向结果链表的头节点
        ListNode temp = new ListNode(0);
        ListNode current = temp;

        // 借位标志
        int borrow = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            // 相减，考虑借位情况
            int diff = val1 - val2 - borrow;
            // 重置借位标志
            borrow = 0;

            if (diff < 0) {
                // 需要借位
                diff += 10;
                // 设置借位标志
                borrow = 1;
            }

            current.next = new ListNode(diff);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 移除结果链表开头的零节点
        while (temp.next != null && temp.next.val == 0) {
            temp.next = temp.next.next;
        }

        return temp.next;
    }
}
