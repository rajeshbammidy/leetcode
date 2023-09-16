class Solution {

    /**
     * Using hashmap to cache using the keys prev+"#"+curindex is giving TLE for some reason.
    So using integer array here.
     */

    private int recur(int ind, int prev, int[][] pairs, int n, Integer[][] dp) {
        if (ind == n) return 0;
        int take = 0, notTake = 0;
        if (dp[ind][prev + 1] != null) return dp[ind][prev + 1];
        if (prev == -1 || pairs[prev][1] < pairs[ind][0]) take = 1 + recur(ind + 1, ind, pairs, n, dp);
        notTake = recur(ind + 1, prev, pairs, n, dp);
        return dp[ind][prev + 1] = Math.max(take, notTake);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int dp[] = new int[n];
        // Integer[][] dp = new Integer[n + 1][n + 1];
        // return recur(0, -1, pairs, n, dp);
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    if ((dp[j] + 1) > dp[i]) {
                        dp[i] = dp[j] + 1;
                        maxLen = Math.max(maxLen, dp[i]);
                    }
                }
            }
        }
      //  System.out.println(Arrays.toString(dp));
        return maxLen;
    }
}
