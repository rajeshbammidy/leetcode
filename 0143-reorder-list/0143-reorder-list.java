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

    public void reorderList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            list.add(cur);
            cur = next;
        }
        int i = 0, n = list.size() - 1;
        head = null;
        ListNode prev = null;
        while (i <= n) {
            ListNode tmp1 = list.get(i);
            ListNode tmp2 = list.get(n);
            if (i == n) tmp2 = null;
            if (head == null) {
                tmp1.next = tmp2;
                head = tmp1;
                prev = tmp2;
            } else {
                prev.next = tmp1;
                tmp1.next = tmp2;
                prev = tmp2;
            }
            i++;
            n--;
        }
    }
}
