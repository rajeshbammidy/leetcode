class Solution {

    public int maximalNetworkRank(int n, int[][] roads) {
        int matrix[][] = new int[n][n];
        int outDeg[] = new int[n];
        int inDeg[] = new int[n];
        for (int road[] : roads) {
            matrix[road[0]][road[1]] = 1;
            matrix[road[1]][road[0]] = 1;
            outDeg[road[0]]++;
            inDeg[road[1]]++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(outDeg[i] + inDeg[i] + outDeg[j] + inDeg[j] - matrix[i][j], max);
            }
        }
        return max;
    }
}
