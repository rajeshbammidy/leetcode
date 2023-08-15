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

    public ListNode partition(ListNode head, int x) {
        ListNode firstHead = new ListNode(0);
        ListNode secHead = new ListNode(0);
        ListNode cur = head, firstCur = firstHead, secCur = secHead;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (cur.val < x) {
                firstCur.next = cur;
                firstCur = cur;
            } else {
                secCur.next = cur;
                secCur = cur;
            }
            cur = next;
        }
        firstCur.next = secHead.next;
        return firstHead.next;
    }
}
