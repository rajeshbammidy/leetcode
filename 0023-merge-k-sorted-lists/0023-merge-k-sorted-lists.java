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
            // Find the min element in all the k lists.
            while (i < k) {
                if (lists[i] != null && min > lists[i].val) {
                    min = lists[i].val;
                    index = i;
                }
                i++;
            }
            // If all the lists are empty.
            if (index == -1) {
                break;
            }
            //assign and iterate.
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
