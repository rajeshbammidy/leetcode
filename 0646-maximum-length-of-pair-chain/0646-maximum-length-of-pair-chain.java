class Solution {

    private int f(int ind, int prev, int[][] pairs, int n, Integer[][] dp) {
        if (ind == n) return 0;
        int take = 0, notTake = 0;
        if (dp[ind][prev + 1] != null) return dp[ind][prev + 1];
        if (prev == -1 || pairs[prev][1] < pairs[ind][0]) take = 1 + f(ind + 1, ind, pairs, n, dp);
        notTake = f(ind + 1, prev, pairs, n, dp);
        return dp[ind][prev + 1] = Math.max(take, notTake);
    }

    private HashMap<String, Integer> map;

    public int findLongestChain(int[][] pairs) {
        map = new HashMap<>();
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        Integer[][] dp = new Integer[n + 1][n + 1];
        return f(0, -1, pairs, n, dp);
    }
}
