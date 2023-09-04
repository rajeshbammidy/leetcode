class Solution {

    static class Node {
        int v;
        int wt;

        Node(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    /**
     *Intution: Vannila Dijkstra
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        int distance[] = new int[n];
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int m = times.length;
        for (int i = 0; i < m; i++) {
            int u = times[i][0] - 1;
            int v = times[i][1] - 1;
            int wt = times[i][2];
            graph.get(u).add(new Node(v, wt));
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k - 1] = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        minHeap.add(new Node(k - 1, 0));
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            int u = node.v;
            int wt = node.wt;
            for (Node nd : graph.get(u)) {
                int v = nd.v;
                int vwt = nd.wt;
                if (distance[v] > (wt + vwt)) {
                    distance[v] = (wt + vwt);
                    minHeap.add(new Node(v, distance[v]));
                }
            }
        }
        int max = 0;
        for (int x : distance) {
            max = Math.max(max, x);
            if (max == Integer.MAX_VALUE) return -1;
        }
        return max;
    }
}
