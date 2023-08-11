class Solution {
    Integer dp[][];

    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount + 1];
        int numOfWays = getNumberOfWays(0, coins, amount);
        return numOfWays;

    }

    private int getNumberOfWays(int i, int[] coins, int amount) {
        if (amount == 0) return 1;
        if (i == coins.length) return 0;
        if (dp[i][amount] != null) return dp[i][amount];

        int waysIncludingCurrentIndex = 0;
        int waysExcludingCurrentIndex = 0;
        if (coins[i] <= amount)
            waysIncludingCurrentIndex = getNumberOfWays(i, coins, amount - coins[i]);
        waysExcludingCurrentIndex = getNumberOfWays(i + 1, coins, amount);

        int total = waysIncludingCurrentIndex + waysExcludingCurrentIndex;
        dp[i][amount] = total;
        return total;
    }
}