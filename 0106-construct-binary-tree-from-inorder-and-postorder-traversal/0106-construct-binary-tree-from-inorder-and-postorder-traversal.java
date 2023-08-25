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
    HashMap<Integer, Integer> inorderToIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        inorderToIndex = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            inorderToIndex.put(inorder[i], i);
        }
        return build(postorder, inorder, 0, n - 1, 0, n - 1);
    }

    TreeNode build(int[] postorder, int[] inorder, int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int inIndex = inorderToIndex.get(postorder[pe]);
        int leftItems = inIndex - is;
        root.left = build(postorder, inorder, is, inIndex - 1, ps, ps + leftItems - 1);
        root.right = build(postorder, inorder, inIndex + 1, ie, ps + leftItems, pe - 1);
        return root;
    }
}
