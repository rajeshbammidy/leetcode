class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int indeg[] = new int[n];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = i;
            for (int j = 0; j < graph[i].length; j++) {
                int v = graph[i][j];
                list.get(v).add(u);
                indeg[u]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) queue.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ans.add(u);
            for (int v : list.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    queue.add(v);
                }
            }
        }
        ans.sort(null);
        return ans;
    }
}
