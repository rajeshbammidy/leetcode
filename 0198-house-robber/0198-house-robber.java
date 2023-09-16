class Solution {

    /***
    ** You cant just do dp[i - 2] + nums[i] for every index i;
    If you are doing above, for every i, leaving (i-1) you should find the max on the left. Instead carry the maxProfit at each i.
    Try for the example 2,1,1,2

    
     */

    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        if (n == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        if (n == 2) {
            return dp[1];
        }
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
