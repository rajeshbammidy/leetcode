class Solution {

    /**
     * Intution: One best trasaction
     */
    public int maxProfit(int[] prices) {
        int leftMin[] = new int[prices.length];
        leftMin[0] = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], prices[i - 1]);
        }

        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (leftMin[i] < prices[i]) {
                ans = Math.max(ans, prices[i] - leftMin[i]);
            }
        }
        return ans;
    }
}
