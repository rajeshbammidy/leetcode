class Solution {

    /**
    
    * Intution : Apply floyd warshall O(V^3) and find the distances for each node from every other node.
    Once done with the above, traverse over the matrix to find the distance <= threshold.

    Point to note is, if A-B distance is 5, B-A distance would also be 5.
     */

    static class Node {
        int v;
        int wt;

        Node(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int m = edges.length;
        int wts[][] = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(wts[i], Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            wts[u][v] = wt;
            wts[v][u] = wt;
        }
        for (int i = 0; i < n; i++) wts[i][i] = 0;

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (wts[i][via] == Integer.MAX_VALUE || wts[via][j] == Integer.MAX_VALUE) continue;
                    wts[i][j] = Math.min(wts[i][j], wts[i][via] + wts[via][j]);
                }
            }
        }

        int maxCount = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (wts[i][j] <= distanceThreshold) count++;
            }
            if (count <= maxCount) {
                maxCount = count;
                index = i;
            }
        }
        return index;
    }
}
