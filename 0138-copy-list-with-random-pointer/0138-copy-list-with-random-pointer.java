/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur=head;
        Node resHead=map.get(cur);
        while(cur!=null){
            Node newNode = map.get(cur);
            newNode.next =cur.next==null?null: map.get(cur.next);
            newNode.random = cur.random==null?null: map.get(cur.random);
            cur=cur.next;

        }
        return resHead;
    }
}
