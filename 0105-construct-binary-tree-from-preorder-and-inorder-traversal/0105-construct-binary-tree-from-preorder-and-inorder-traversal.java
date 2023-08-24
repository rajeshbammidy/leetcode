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
    int preoIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        return build(0, preorder.length - 1, preorder, inorder);
    }

    TreeNode build(int start, int end, int[] preorder, int[] inorder) {
        if (start > end) return null;
        int element = preorder[preoIndex++];
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == element) {
                index = i;
                break;
            }
        }
        TreeNode node = new TreeNode(element);
        node.left = build(start, index - 1, preorder, inorder);
        node.right = build(index + 1, end, preorder, inorder);
        return node;
    }
}
