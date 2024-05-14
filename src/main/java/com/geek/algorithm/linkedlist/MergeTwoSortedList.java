package com.geek.algorithm.linkedlist;

/**
 * @author lucas.zhao
 * @date 2023/07/30 23:14
 * @email jczhao_cs@163.com
 */

/**
 * 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists
 * 标签：递归
 *
 * 解题思路：
 *  1.假设 list1[0] < list2[0]
 *  2.取出list1[0]，然后解决子问题即合并list1->next和list2，list1->next指向子问题的合并结果
 *  3.子问题和原问题具有相同的结构，可以通过递归解决
 *  4.递归伪代码：merge(list1, list2) 等价于 list1->next = merge(list1->next, list2)
 *  5.需要考虑list1或者list2为空链表时的边界情况
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {        // 如果list1为空，则直接返回list2
            return list2;
        } else if (list2 == null) { // 如果list2为空，则直接返回list1
            return list1;
        } else if (list1.val < list2.val) { // 如果list1的头结点比较小，则使list1的剩余节点和list2合并
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }
}
