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

    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 1;
        ListNode cur = head;
        ListNode ans[] = new ListNode[k];
        if (cur == null) {
            return ans;
        }
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        int rmng = count % k;
        int each = count / k;
        // System.out.println(rmng + " " + each);

        int index = 0;
        cur = head;
        count = 0;
        ListNode curHead = cur;
        while (cur != null) {
            System.out.println(cur.val);
            ListNode next = cur.next;
            if (count < each) {
                System.out.println("in 1");
                count++;
            } else if (count >= each && rmng > 0) {
                rmng--;
                System.out.println("in 2");
                cur.next = null;
                ans[index++] = curHead;
                curHead = next;
                cur = next;
                count = 0;
                continue;
            }
            if (count >= each && rmng == 0) {
                System.out.println("in 3");
                cur.next = null;
                ans[index++] = curHead;
                curHead = next;
                count = 0;
            }
            cur = next;
        }
        while (index < k) {
            ans[index++] = null;
        }
        return ans;
    }
}
