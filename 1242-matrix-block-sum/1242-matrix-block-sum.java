class Solution {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int dp[][] = new int[m][n];
        dp[0] = mat[0].clone();
        //col-wise vertical sum
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + mat[i][j];
            }
        }
        //row-wise horizontal sum
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] += dp[i][j - 1];
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        int res[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int btmRRow = (i + k) >= m ? m - 1 : i + k;
                int btmRCol = (j + k) >= n ? n - 1 : j + k;
                int topLRow = (i - k) < 0 ? 0 : i - k;
                int topLCol = (j - k) < 0 ? 0 : j - k;
                boolean btmLeftDeleted = false, topRightDeleted = false;
                int sum = dp[btmRRow][btmRCol];
                if (topLCol > 0) {
                    btmLeftDeleted = true;
                    sum -= dp[btmRRow][topLCol - 1];
                }
                if (topLRow > 0) {
                    topRightDeleted = true;
                    sum -= dp[topLRow - 1][btmRCol];
                }
                if (btmLeftDeleted && topRightDeleted) {
                    sum += (dp[topLRow - 1][topLCol - 1]);
                }
                res[i][j] = sum;
            }
        }

        return res;
    }
}
