class Solution {

    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        if (n <= 3) return n;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; (j * j <= i); j++) {
                int temp = j * j;
                dp[i] = Math.min(dp[i], dp[i - temp] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
