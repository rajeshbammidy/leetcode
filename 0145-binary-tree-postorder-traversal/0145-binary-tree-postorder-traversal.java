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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            while (cur != null) {
                TreeNode left = cur.left;
                cur.left = null;
                stack.push(cur);
                cur = left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                if (cur.right == null && cur.left == null) {
                    list.add(cur.val);
                    cur = stack.isEmpty() ? null : stack.pop();
                } else {
                    TreeNode right = cur.right;
                    cur.right = null;
                    stack.push(cur);
                    cur = right;
                }
            }
        }
        return list;
    }
}
