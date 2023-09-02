class Solution {

    static class Node {
        int v;
        int wt;

        Node(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Node>());
        }
        int len = flights.length;
        for (int i = 0; i < len; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int dist = flights[i][2];
            graph.get(u).add(new Node(v, dist));
        }
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.level - b.level);
        minHeap.add(new Pair(new Node(src, 0), 0));
        while (!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            int u = pair.node.v;
            int wt = pair.node.wt;
            int stops = pair.level;
            for (Node node : graph.get(u)) {
                int v = node.v;
                int vwt = node.wt;
                if ((wt + vwt) < dist[v] && v != dst) {
                    dist[v] = wt + vwt;
                    minHeap.add(new Pair(new Node(v, dist[v]), stops + 1));
                } else if ((wt + vwt) < dist[v] && v == dst && stops <= k) {
                    dist[v] = wt + vwt;
                    minHeap.add(new Pair(new Node(v, dist[v]), stops + 1));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
