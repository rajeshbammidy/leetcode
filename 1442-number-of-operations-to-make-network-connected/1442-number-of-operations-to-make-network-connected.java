class Solution {
    static int parent[];
    static int height[];

    /**
     * PathCompression
     */
    static int find(int x) {
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    /**
     * Union By Rank
     */
    static void union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);
        if (x_rep == y_rep) return;
        if (height[x_rep] > height[y_rep]) {
            parent[y_rep] = x_rep;
        } else if (height[x_rep] < height[y_rep]) {
            parent[x_rep] = y_rep;
        } else {
            parent[y_rep] = x_rep;
            height[x_rep]++;
        }

    }

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int extras = 0;
        for (int i = 0; i < connections.length; i++) {
            int x_rep = find(connections[i][0]);
            int y_rep = find(connections[i][1]);
            /**
             * If connections[i][0],connections[i][1] are already in the same group, it's an extra edge
             */
            if (x_rep == y_rep) {
                extras++;
                continue;
            }
            /**
             * Otherwise union them to form a group
             */
            union(x_rep, y_rep);
        }

        HashSet<Integer> set = new HashSet<>();
        /**
         * Now, check the number of disconnected groups.
         */
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }
        /**
         * If there are n disconnected groups, we would need n-1 edges to connect them.
         */
        int disConnectedNodes = set.size() - 1;
        if (extras < disConnectedNodes) return -1;
        return disConnectedNodes;

    }
}