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
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        count = 0;
        recur(root);
        return count;
    }

    int[] recur(TreeNode root) {
        if (root != null) {
            int left[] = recur(root.left);
            int right[] = recur(root.right);
            int total[] = new int[2];
            total[0] = left[0] + right[0] + 1;
            total[1] = left[1] + right[1] + root.val;
            if (root.val == total[1] / total[0]) count++;
            return total;
        }
        return new int[] { 0, 0 };
    }
}
