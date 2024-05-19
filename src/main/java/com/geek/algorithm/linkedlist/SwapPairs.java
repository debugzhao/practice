package com.geek.algorithm.linkedlist;

/**
 * @Author zhaojingchao
 * @Date 2024/05/19 12:22
 * @Email zhaojingchao@joysuch.com
 * @Desc 两两交换链表中的节点：虚拟节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * https://programmercarl.com/0024.%E4%B8%A4%E4%B8%A4%E4%BA%A4%E6%8D%A2%E9%93%BE%E8%A1%A8%E4%B8%AD%E7%9A%84%E8%8A%82%E7%82%B9.html#%E6%80%9D%E8%B7%AF
 */
public class SwapPairs {

    /**
     * 使用虚拟头结点解决，这样不用针对头结点做额外的处理
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;

        // 如果节点的个数是奇数个，需要判断cur.next.next != null。这里先进行短路与判断，判断cur.next是否为空
        // 如果节点的个数是偶数个，需要判断cur.next是否为空
        while (cur.next != null && cur.next.next != null) {
            // 保存临时节点
            ListNode temp = cur.next;
            ListNode temp1 = cur.next.next.next;

            // 两两交换节点
            cur.next = cur.next.next;
            cur.next.next = temp;
            temp.next = temp1;

            cur = cur.next.next;
        }
        return dummyHead.next;
    }
}
