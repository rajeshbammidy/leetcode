class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        dp[0] = matrix[0].clone();
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int current = matrix[i][j];
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                int middle = Integer.MAX_VALUE;

                if (j - 1 >= 0) {
                    left = current + dp[i - 1][j - 1];
                }
                if (j + 1 < n) {
                    right = current + dp[i - 1][j + 1];
                }
                middle = current + dp[i - 1][j];

                dp[i][j] = Math.min(Math.min(left, right), middle);

            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(dp[m - 1][i], min);
        }
        return min;

    }
}