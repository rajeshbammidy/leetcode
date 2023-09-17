class Solution {
    Integer dp[][];

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new Integer[n][amount + 1];
        int res = recur(0, coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int recur(int index, int coins[], int amount) {
        if (amount == 0) return 0;
        if (index >= coins.length) return Integer.MAX_VALUE;
        if (dp[index][amount] != null) return dp[index][amount];
        int take = Integer.MAX_VALUE;
        int notTake = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            int value = recur(index, coins, amount - coins[index]);
            if (value != Integer.MAX_VALUE) take = 1 + value;
        }
        notTake = recur(index + 1, coins, amount);
        return dp[index][amount] = Math.min(take, notTake);
    }
}
