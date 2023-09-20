class Solution {
    Integer dp[][][];

    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2][3];
        return findMaxProfit(prices, 0, 1, 2);

    }

    private int findMaxProfit(int[] prices, int index, int isBuy, int k) {

        if (k == 0 || index == prices.length) return 0;
        if (dp[index][isBuy][k] != null) return dp[index][isBuy][k];

        /**
         * If isBuy= true
         * You have two choices:
         * 1.Buy the stock and go next index,(if it all we are buying we anticipate the bigger peak from the right side)
         * 2.Skip the buy
         *
         *
         */
        if (isBuy == 1) {
            dp[index][isBuy][k] = Math.max(findMaxProfit(prices, index + 1, 0, k) - prices[index],
                    findMaxProfit(prices, index + 1, 1, k));
            return dp[index][isBuy][k];
        } else {
            /**
             * If isBuy= false
             * You have two choices:
             * 1.Sell the stock and go next index with k= k-1
             * 2.Skip the sell
             *
             *
             */
            dp[index][isBuy][k] = Math.max(
                    findMaxProfit(prices, index + 1, 1, k - 1) + prices[index],
                    findMaxProfit(prices, index + 1, 0, k));
            return dp[index][isBuy][k];

        }
    }
}