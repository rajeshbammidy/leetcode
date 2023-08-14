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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            ArrayList<Integer> list1 = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                list1.add(node.val);
                if (node.left != null) s2.push(node.left);
                if (node.right != null) s2.push(node.right);
            }
            if (list1.size() > 0) result.add(list1);
            ArrayList<Integer> list2 = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                list2.add(node.val);
                if (node.right != null) s1.push(node.right);
                if (node.left != null) s1.push(node.left);
            }
            if (list2.size() > 0) result.add(list2);
        }
        return result;
    }
}
