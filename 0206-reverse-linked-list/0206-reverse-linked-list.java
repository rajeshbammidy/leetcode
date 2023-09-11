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
    private ListNode rhead = null;

    public ListNode reverseList(ListNode head) {
        rhead = null;
        return recur(null, head);
    }

    ListNode recur(ListNode prev, ListNode cur) {
        if (cur == null) return null;
        if (cur.next == null) {
            cur.next = prev;
            return cur;
        }
        ListNode next = cur.next;
        cur.next = prev;
        return recur(cur, next);
    }
}
