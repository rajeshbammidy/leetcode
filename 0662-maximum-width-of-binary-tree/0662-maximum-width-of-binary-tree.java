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

/**
 ** Note: Adding null as a place holder and finding the breadth will give TLE.


  public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxBreadth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            int firstIndex = -1;
            int lastIndex = -1;
            while (i < size) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (firstIndex == -1) firstIndex = i;
                    lastIndex = i;
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    queue.add(null);
                    queue.add(null);
                }
                i++;
            }
            if (firstIndex == -1 || lastIndex == -1) {
                return maxBreadth;
            }
            maxBreadth = Math.max(maxBreadth, lastIndex - firstIndex + 1);
        }
        return maxBreadth;
    }
 **
  */
class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        int maxBreadth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(size);
            int i = 0;
            int firstIndex = -1;
            int lastIndex = -1;
            while (i < size) {
                Pair<TreeNode, Integer> pair = queue.poll();
                int currentNodeValue = pair.getValue();
                TreeNode node = pair.getKey();
                if (node != null) {
                    if (firstIndex == -1) firstIndex = currentNodeValue;
                    lastIndex = currentNodeValue;
                    if (node.left != null) queue.add(new Pair(node.left, 2 * currentNodeValue));
                    if (node.right != null) queue.add(new Pair(node.right, 2 * currentNodeValue + 1));
                }
                i++;
            }
            maxBreadth = Math.max(maxBreadth, lastIndex - firstIndex + 1);
        }
        return maxBreadth;
    }
}
