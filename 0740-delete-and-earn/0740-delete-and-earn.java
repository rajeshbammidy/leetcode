class Solution {

    public int deleteAndEarn(int[] nums) {
        int dp[] = new int[(int) (2 * 1e4)];
        int n = dp.length;
        for (int x : nums) {
            dp[x] += x;
        }
        dp[1] = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + dp[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
