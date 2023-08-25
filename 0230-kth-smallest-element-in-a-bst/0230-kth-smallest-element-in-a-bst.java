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
    int element = 0;
    int kindex = 0;

    public int kthSmallest(TreeNode root, int k) {
        kindex = 0;
        element = 0;
        inorder(root, k);
        return element;
    }

    void inorder(TreeNode root, int k) {
        if (root != null) {
            inorder(root.left, k);
            kindex++;
            if (kindex == k) {
                element = root.val;
                return;
            }
            inorder(root.right, k);
        }
    }
}
