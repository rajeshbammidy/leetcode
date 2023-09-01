class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int ans[] = new int[numCourses];
        int index = 0;
        int m = prerequisites.length;
        if (m == 0) {
            for (int i = 0; i < numCourses; i++) ans[index++] = i;
            return ans;
        }
        HashMap<Integer, Integer> nodeToIndeg = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
            nodeToIndeg.put(i, 0);
        }

        for (int i = 0; i < m; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(v).add(u);
            nodeToIndeg.put(u, nodeToIndeg.get(u) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int x : nodeToIndeg.keySet()) {
            if (nodeToIndeg.get(x) == 0) {
                queue.add(x);
            }
        }
        if (queue.isEmpty()) return new int[0];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            list.add(u);
            for (int v : graph.get(u)) {
                int childIndeg = nodeToIndeg.get(v);
                childIndeg -= 1;
                nodeToIndeg.put(v, childIndeg);
                if (childIndeg == 0) queue.add(v);
            }
        }
        if (list.size() != numCourses) return new int[0];
        for (int x : list) {
            ans[index++] = x;
        }
        return ans;
    }
}
