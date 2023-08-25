/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }

    TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            if (root.val == p.val || root.val == q.val) return root;
            TreeNode left = null, right = null;

            if (p.val < root.val || q.val < root.val) {
                left = lca(root.left, p, q);
            }
            if (p.val > root.val || q.val > root.val) {
                right = lca(root.right, p, q);
            }
            if (left != null && right != null) return root;
            if (left == null) return right;
            return left;
        }
        return null;
    }
}
