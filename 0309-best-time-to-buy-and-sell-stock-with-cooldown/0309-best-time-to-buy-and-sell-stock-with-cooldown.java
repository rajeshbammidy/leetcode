class Solution {
    Integer dp[][];

    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return findMaxProfit(prices, 0, 1);
    }

    private int findMaxProfit(int[] prices, int index, int isBuy) {

        if (index >= prices.length) return 0;
        if (dp[index][isBuy] != null) return dp[index][isBuy];

        /**
         * If isBuy= true
         * You have two choices:
         * 1.Buy the stock and go next index,(if it all we are buying we anticipate the bigger peak from the right side)
         * 2.Skip the buy
         *
         *
         */
        if (isBuy == 1) {
            dp[index][isBuy] = Math.max(findMaxProfit(prices, index + 1, 0) - prices[index],
                    findMaxProfit(prices, index + 1, 1));
            return dp[index][isBuy];
        } else {
            /**
             * If isBuy= false
             * You have two choices:
             * 1.Sell the stock and go next index with index=index+2 (since there is a cool down period)
             * 2.Skip the sell
             *
             *
             */
            dp[index][isBuy] = Math.max(
                    findMaxProfit(prices, index + 2, 1) + prices[index],
                    findMaxProfit(prices, index + 1, 0));
            return dp[index][isBuy];

        }
    }
}