package easy.reverselinkedlist;

import common.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseList2(head);
    }

    private ListNode reverseList1(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode reversed = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }

    private ListNode reverseList2(ListNode head) {
        ListNode reversed = null;
        while (head != null) {
            ListNode oldreversed = reversed;
            reversed = head;
            head = head.next;
            reversed.next = oldreversed;
        }
        return reversed;
    }
}