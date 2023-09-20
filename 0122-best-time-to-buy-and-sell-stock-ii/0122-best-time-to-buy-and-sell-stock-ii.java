class Solution {

    public int maxProfit(int[] prices) {
        int max = 0, n = prices.length;
        int prev = prices[0], start = prices[0];
        int idx = 1;
        while (idx < n) {
            if (prices[idx] < prev) {
                max += (prev - start);
                start = prices[idx];
            }
            prev = prices[idx];
            idx++;
            if (idx == n) {
                if (start < prev) {
                    max += (prev - start);
                }
            }
        }
        return max;
    }
}
