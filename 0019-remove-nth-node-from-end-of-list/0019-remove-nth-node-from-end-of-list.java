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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head, prev = node;
        while (n > 0 && head != null) {
            head = head.next;
            n--;
        }
       

        if (head == null) {
            prev = prev.next;
            return prev;
        }
        while (head.next != null) {
            head = head.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return node;
    }
}