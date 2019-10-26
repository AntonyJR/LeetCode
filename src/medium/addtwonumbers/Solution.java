package medium.addtwonumbers;

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode current = sum;
        ListNode n1 = l1;
        ListNode n2 = l2;
        int carry = 0;
        while (n1 != null && n2 != null) {
            int s = n1.val + n2.val + carry;
            carry = s / 10;
            current.next = new ListNode(s % 10);
            current = current.next;
            n1 = n1.next;
            n2 = n2.next;
        }
        while (n1 != null) {
            int s = n1.val + carry;
            carry = s / 10;
            current.next = new ListNode(s % 10);
            current = current.next;
            n1 = n1.next;
        }
        while (n2 != null) {
            int s = n2.val + carry;
            carry = s / 10;
            current.next = new ListNode(s % 10);
            current = current.next;
            n2 = n2.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return sum.next;
    }
}