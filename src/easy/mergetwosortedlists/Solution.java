package easy.mergetwosortedlists;

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Empty Input
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Initialize
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode result;
        if (c1.val < c2.val) {
            result = c1;
            c1 = c1.next;
        }
        else {
            result = c2;
            c2 = c2.next;
        }
        ListNode current = result;

        // Move through Lists
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                current.next = c1;
                current = c1;
                c1 = c1.next;
            }
            else {
                current.next = c2;
                current = c2;
                c2 = c2.next;
            }
        }

        // Only one list left
        if (c1 == null)
            current.next = c2;
        else
            current.next = c1;
        return result;
    }
}