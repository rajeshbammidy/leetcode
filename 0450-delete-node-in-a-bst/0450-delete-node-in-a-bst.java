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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode head = root;
        if (root.val == key) {
            return getSubTree(root);
        }
        while (root != null) {
            if (key < root.val) {
                if (root.left != null && root.left.val == key) {
                    root.left = getSubTree(root.left);
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = getSubTree(root.right);
                } else {
                    root = root.right;
                }
            }
        }
        return head;
    }

    TreeNode getSubTree(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        TreeNode rightSubTree = root.right;
        root = root.left;
        TreeNode leftSubTree = root;
        while (root.right != null) {
            root = root.right;
        }
        root.right = rightSubTree;
        return leftSubTree;
    }
}
