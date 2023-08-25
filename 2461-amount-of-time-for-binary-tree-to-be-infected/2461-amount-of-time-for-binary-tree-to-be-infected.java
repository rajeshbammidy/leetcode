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
    /**
     * Question is similar to https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
     */
    int max = 0;

    public int amountOfTime(TreeNode root, int start) {
        max = 0;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> nodeToDistanceMap = new HashMap<>();
        findDistance(root, start, nodeToDistanceMap);
        findNodes(root, start, nodeToDistanceMap, 0, result);
        return max;
    }

    void findNodes(TreeNode root, int target, HashMap<Integer, Integer> nodeToDistanceMap, int distance, ArrayList<Integer> result) {
        if (root != null) {
            if (nodeToDistanceMap.get(root.val) != null) {
                distance = nodeToDistanceMap.get(root.val);
            }
            max = Math.max(max, distance);
            findNodes(root.left, target, nodeToDistanceMap, distance + 1, result);
            findNodes(root.right, target, nodeToDistanceMap, distance + 1, result);
        }
    }

    int findDistance(TreeNode root, int target, HashMap<Integer, Integer> nodeToDistanceMap) {
        if (root != null) {
            if (root.val == target) {
                nodeToDistanceMap.put(target, 0);
                return 1;
            }
            int left = findDistance(root.left, target, nodeToDistanceMap);
            int right = findDistance(root.right, target, nodeToDistanceMap);
            if (left > 0) {
                nodeToDistanceMap.put(root.val, left);
                return left + 1;
            } else if (right > 0) {
                nodeToDistanceMap.put(root.val, right);
                return right + 1;
            }
        }
        return 0;
    }
}
