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
    int maxLevel = 0;

    public List<Integer> rightSideView(TreeNode root) {
        maxLevel=0;
        List<Integer> result = new ArrayList<>();
        findRightView(root, result, 1);
        return result;
    }

    void findRightView(TreeNode root, List<Integer> result, int level) {
        if (root != null) {
            if (maxLevel < level) {
                result.add(root.val);
                maxLevel = level;
            }
            findRightView(root.right, result, level + 1);
            findRightView(root.left, result, level + 1);
        }
    }
}
