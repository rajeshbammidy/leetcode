/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        if (fast == null || fast.next == null) return false;
        fast = fast.next.next;
        while (fast != null && fast.next != null && slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) return false;
        return slow.next == fast.next;
    }
}
