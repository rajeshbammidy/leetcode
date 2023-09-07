/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prevHead = null, leftStart = null, rightEnd = null;
        ListNode cur = head;
        int count = 1;
        while (count != left && cur != null) {
            prevHead = cur;
            cur = cur.next;
            count++;
        }
        if (prevHead != null) prevHead.next = null;
        leftStart = cur;
        while (count != right && cur != null) {
            cur = cur.next;
            count++;
        }
        ListNode rightEndNext = cur.next;
        cur.next = null;
        ListNode prev = null, revEnd = null;
        while (leftStart != null) {
            ListNode next = leftStart.next;
            leftStart.next = prev;
            prev = leftStart;
            if (revEnd == null) revEnd = prev;
            leftStart = next;
        }

        if (prevHead != null) prevHead.next = prev; else head = prev;
        revEnd.next = rightEndNext;
        return head;
    }
}
