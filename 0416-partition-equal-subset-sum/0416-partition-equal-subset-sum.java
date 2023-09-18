class Solution {
    Boolean dp[][];

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) sum += x;
        if ((sum & 1) != 0) return false;
        dp = new Boolean[nums.length][sum / 2 + 1];
        return recur(0, sum / 2, nums);
    }

    boolean recur(int idx, int sum, int nums[]) {
        if (sum < 0) return false;
        if (sum == 0) {
            return true;
        }
        if (idx >= nums.length) return false;
        if (dp[idx][sum] != null) return dp[idx][sum];

        boolean take = false;
        if (nums[idx] <= sum) {
            take = recur(idx + 1, sum - nums[idx], nums);
        }
        return dp[idx][sum] = take | recur(idx + 1, sum, nums);
    }
}
