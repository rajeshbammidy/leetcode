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
       HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return findIfTargetExists(root, k);

    }

    private boolean findIfTargetExists(TreeNode root, int k) {
        if (root != null) {
            if (set.contains(k - root.val)) return true;
            set.add(root.val);
            boolean left = findTarget(root.left, k);
            if (left) return true;
            boolean right = findTarget(root.right, k);
            if (right) return true;

        }
        return false;
    }
}