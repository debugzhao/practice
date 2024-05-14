package com.geek.algorithm.linkedlist;

/**
 * @author lucas.zhao
 * @date 2023/07/30 18:09
 * @email jczhao_cs@163.com
 */

/**
 * 获取链表中倒数第k个节点
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/?company_slug=xiaohongshu
 *
 * 标签：快慢指针
 * 解题思路：
 *
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 1.先定义两个快慢指针
        ListNode faster = head;
        ListNode slower = head;

        // 2.快指针先移动k个节点
        for (int i = 0; i < k; i++) {
            faster = faster.next;
        }
        // 3.然后快慢指针都开始向后移动1个节点
        // 4.直到快指针移动到尾结点的后一个位置（faster = null）
        // 此时慢指针恰好指向链表中倒数第k个节点
        while (faster != null) {
            faster = faster.next;
            slower = slower.next;
        }
        return slower;
    }
}
