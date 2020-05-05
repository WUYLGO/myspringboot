package com.example.demo.algrorithm;

/**
 * @Description: 21. 合并两个有序链表
 * @Date: 2020/5/1 12:01
 * @Idea: 使用哨兵节点, 然后同时遍历两个链表
 */
class Solution21 {
    public class ListNode {
        private ListNode next;
        private Integer val;


        public ListNode(Integer val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sential = new ListNode(0);
        ListNode prev = sential;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 == null) {
            prev.next = l2;
        } else {
            prev.next = l1;
        }

        return sential.next;
    }
}
