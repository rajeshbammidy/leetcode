/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
        Intution: If the target is always root,then it is easy to find the nodes at distance k,which would be its descendants.But here the target could be any node. So we use hashing to store the distances from the target
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> nodeToDistanceMap = new HashMap<>();
        findDistance(root, target.val, nodeToDistanceMap);
        findNodes(root, target.val, k, nodeToDistanceMap, 0, result);
        return result;
    }

    void findNodes(TreeNode root, int target, int k, HashMap<Integer, Integer> nodeToDistanceMap, int distance, ArrayList<Integer> result) {
        if (root != null) {
            if (nodeToDistanceMap.get(root.val) != null) {
                distance = nodeToDistanceMap.get(root.val);
            }
            if (distance == k) {
                result.add(root.val);
            }
            findNodes(root.left, target, k, nodeToDistanceMap, distance + 1, result);
            findNodes(root.right, target, k, nodeToDistanceMap, distance + 1, result);
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
