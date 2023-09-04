class Solution {
    static int timer = 0;
    List<List<Integer>> result;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int clen = connections.size();
        for (int i = 0; i < clen; i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int tin[] = new int[n];
        int low[] = new int[n];
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, tin, low, graph, visited, -1);
            }
        }
        return result;
    }

    void dfs(int index, int tin[], int low[], List<List<Integer>> graph, HashSet<Integer> visited, int parent) {
        visited.add(index);

        tin[index] = low[index] = timer++;
        for (int v : graph.get(index)) {
            if (v == parent) continue;
            if (!visited.contains(v)) {
                dfs(v, tin, low, graph, visited, index);
                low[index] = Math.min(low[index], low[v]);
                if (tin[index] < low[v]) {
                    result.add(Arrays.asList(index, v));
                }
            } else {
                low[index] = Math.min(low[index], low[v]);
            }
        }
    }
}
