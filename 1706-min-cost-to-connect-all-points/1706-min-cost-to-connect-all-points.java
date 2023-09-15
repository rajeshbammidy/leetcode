class Solution {

    static class Node {
        int u;
        int v;
        int wt;

        Node(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    int parent[];
    int height[];

    int find(int x) {
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;
        if (height[py] > height[px]) {
            parent[px] = py;
            height[py]++;
        } else {
            parent[py] = px;
            height[px]++;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>(
            (a, b) -> {
                return a.wt - b.wt;
            }
        );
        for (int i = 0; i < n; i++) {
            int px = points[i][0];
            int py = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int cx = points[j][0];
                int cy = points[j][1];
                int distance = Math.abs(px - cx) + Math.abs(py - cy);
                minHeap.add(new Node(i, j, distance));
                minHeap.add(new Node(j, i, distance));
            }
        }
        int mstDistance = 0;
        int finalized = 0;
        while (!minHeap.isEmpty() && finalized < (n - 1)) {
            Node node = minHeap.poll();
            int x = node.u;
            int y = node.v;
            int wt = node.wt;
            int px = find(x);
            int py = find(y);
            if (px == py) continue;
            union(x, y);
            finalized++;
            mstDistance += wt;
        }
        return mstDistance;
    }
}
