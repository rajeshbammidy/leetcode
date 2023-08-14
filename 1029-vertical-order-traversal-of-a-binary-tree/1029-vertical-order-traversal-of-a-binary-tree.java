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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> curMap = new TreeMap<>();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> p = queue.poll();
                TreeNode node = p.getKey();
                int hd = p.getValue();
                curMap.putIfAbsent(hd, new ArrayList<>());
                curMap.get(hd).add(node.val);
                if (node.left != null) {
                    queue.add(new Pair<>(node.left, hd - 1));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, hd + 1));
                }
            }

            for (Map.Entry<Integer, List<Integer>> entry : curMap.entrySet()) {
                entry.getValue().sort(null);
                map.putIfAbsent(entry.getKey(), new ArrayList<>());
                map.get(entry.getKey()).addAll(entry.getValue());
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
