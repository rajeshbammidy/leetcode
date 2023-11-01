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
    int maxCount = 0;
    int count = 0;
    Integer prev = null;
    Integer maxMode = null;
    ArrayList<Integer> list;

    public int[] findMode(TreeNode root) {
        maxCount = 0;
        count = 0;
        prev = null;
        recur(root);
        count = 0;
        prev = null;
        maxMode = maxCount;
        maxCount = 0;
        list = new ArrayList<>();
        recur(root);
        int ans[] = new int[list.size()];
        int i = 0;
        for (int x : list) {
            ans[i++] = x;
        }
        return ans;
    }

    void recur(TreeNode root) {
        if (root != null) {
            recur(root.left);
            findMode(root.val);
            recur(root.right);
        }
    }

    void findMode(int val) {
        if (prev == null) {
            count = 1;
            prev = val;
            maxCount = 1;
        } else if (prev != val) {
            prev = val;
            count = 1;
        } else if (prev == val) {
            count++;
            maxCount = Math.max(count, maxCount);
        }
        if (maxMode != null && count == maxMode) {
           
            if (list.isEmpty()) {
                list.add(val);
            } else if (!list.isEmpty() && list.get(list.size() - 1) != val) {
                list.add(val);
            }
        }
    }
}
