class Solution {
    /***
    
    Intution: If you observe the inputs
    1.When two stones are equal we are cancelling them
    2.When one stone is greater the smaller one is getting destroyed and we are taking the diff
    
    And the task is to make the last stone should have least weight.
    So this has basically equals to min difference bewteen the subsets.
     */

    Boolean dp[][];

    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        /**
         * Find the totalSum of elements in the stones array
         */
        for (int x : stones) totalSum += x;
        /**
         * Since we would have to check if subset till half of the total sum.
         * Remember the equation (2*s1-totalSum)
         */
        int half = totalSum / 2;
        dp = new Boolean[stones.length + 1][half + 1];
        recur(0, half, stones);
        /**
         * Find min difference from the following eq:(2 * s1 - totalSum)
         */
        int minDiff = Integer.MAX_VALUE;
        int m = dp.length;
        for (int i = 0; i <= half; i++) {
            if (dp[m - 1][i]) minDiff = Math.min(minDiff, Math.abs(2 * i - totalSum));
        }

        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }

    void recur(int idx, int sum, int nums[]) {
        Arrays.fill(dp[0], false);
        int n = dp.length;
        int m = dp[0].length;
        for (int i = 0; i < n; i++) dp[i][0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    }
}
