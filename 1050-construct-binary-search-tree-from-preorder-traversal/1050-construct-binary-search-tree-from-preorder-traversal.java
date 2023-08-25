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
    int preIndex = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, preorder.length, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode buildBST(int[] preorder, int n, int min, int max) {
        if (preIndex >= n) {
            return null;
        }

        int key = preorder[preIndex];
        TreeNode root = null;
        if (key > min && key < max) {
            root = new TreeNode(key);
            preIndex++;
            root.left = buildBST(preorder, n, min, key);
            root.right = buildBST(preorder, n, key, max);
        }
        return root;
    }
}
