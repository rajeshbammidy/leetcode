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

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode head = new ListNode(0);
        boolean allEmpty = false;
        ListNode cur = head;
        while (!allEmpty) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            int i = 0;
            while (i < k) {
                if (lists[i] != null && min > lists[i].val) {
                    min = lists[i].val;
                    index = i;
                }
                i++;
            }
            if (index == -1) {
                break;
            }
            ListNode tempNode = lists[index];
            ListNode next = tempNode.next;
            tempNode.next = null;
            cur.next = tempNode;
            cur = tempNode;
            lists[index] = next;
        }
        return head.next;
    }
}
