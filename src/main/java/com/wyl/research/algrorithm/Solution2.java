package com.wyl.research.algrorithm;

class Solution2 {
    public static void main(String[] args) {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curr = temp;
        int carry = 0;
        while (p1 != null && p2 != null) {
            int x = (p1 != null ? p1.val : 0);
            int y = (p2 != null ? p2.val : 0);
            int sum = x + y + carry;
            carry = carry / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return temp.next;

    }

    public class ListNode {
        private ListNode next;
        private Integer val;

        public ListNode(Integer val) {
            this.val = val;
        }
    }


}

