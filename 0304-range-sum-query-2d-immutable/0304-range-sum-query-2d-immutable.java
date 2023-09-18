class NumMatrix {
    int dp[][];

    public NumMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        dp = new int[m][n];
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
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int btmRRow = row2;
        int btmRCol = col2;
        int topLRow = row1;
        int topLCol = col1;
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
        return sum;
    }
}
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
