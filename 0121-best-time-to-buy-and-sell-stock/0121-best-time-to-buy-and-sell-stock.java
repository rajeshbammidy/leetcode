class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxRight[] = new int[n];
        int idx = n - 1;
        int rightMax = idx;
        while (idx >= 0) {
            if (prices[idx] < prices[rightMax]) {
                maxRight[idx] = rightMax;
            } else {
                maxRight[idx] = -1;
                rightMax = idx;
            }
            idx--;
        }
        int max = 0;
        idx = 0;
        while (idx < n) {
            if (maxRight[idx] != -1) {
                max = Math.max(max, prices[maxRight[idx]] - prices[idx]);
            }
            idx++;
        }
        return max;
    }
}
