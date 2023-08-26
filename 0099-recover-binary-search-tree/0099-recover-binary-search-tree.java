/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode node1 = null, node2 = null, node3 = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        node1 = null;
        node2 = null;
        node3 = null;
        inorder(root);
        if (node3 != null && node1 != null) {
            int x = node1.val;
            node1.val = node3.val;
            node3.val = x;
        } else if (node1 != null) {
            int x = node1.val;
            node1.val = node2.val;
            node2.val = x;
        }
    }

    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            if (prev == null || prev.val < root.val) {
                prev = root;
            } else {
                if (node1 == null) {
                    node1 = prev;
                    node2 = root;
                    prev = root;
                } else if (node3 == null) {
                    node3 = root;
                }
            }
            inorder(root.right);
        }
    }
}
