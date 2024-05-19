package com.geek.algorithm.linkedlist;

/**
 * @Author zhaojingchao
 * @Date 2024/05/18 23:44
 * @Email zhaojingchao@joysuch.com
 * @Desc 反转链表：递归|双指针
 * https://leetcode.cn/problems/reverse-linked-list/
 * https://programmercarl.com/0206.%E7%BF%BB%E8%BD%AC%E9%93%BE%E8%A1%A8.html#%E6%80%9D%E8%B7%AF
 */
public class ReverseList {


    /**
     *  双指针实现
     */
    public ListNode reverseList1(ListNode head) {
        // pre节点是cur节点的前一个节点
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) { // 写循环一定要先考虑循环终止条件
            ListNode temp = cur.next;
            // 反转赋值
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 递归实现
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        return null;
    }

    public ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        // 更新cur、pre位置
        // pre = cur;
        // cur = temp;
        return reverse(temp, cur);
    }
}
