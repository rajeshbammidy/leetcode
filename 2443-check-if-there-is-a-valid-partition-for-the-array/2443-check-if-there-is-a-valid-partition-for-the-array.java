class Solution {

    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean dp[] = new boolean[n];
        if (n == 1) return false;
        //basecase
        dp[0] = false;
        //check if first two elements are equal
        dp[1] = nums[1] == nums[0];
        for (int i = 2; i < n; i++) {
            // check for all three conditions
            boolean v1 = isTwoElementsEqual(i, nums);
            boolean v2 = isThreeElementsEqual(i, nums);
            boolean v3 = isThreeConsEqual(i, nums);
            if (v1) {
                dp[i] = dp[i - 2];
            }
            if (v2 || v3) {
                dp[i] = dp[i] || ((i - 3) < 0 ? true : dp[i - 3]);
            }
        }
        return dp[n - 1];
    }

    boolean isTwoElementsEqual(int i, int[] nums) {
        return nums[i] == nums[i - 1];
    }

    boolean isThreeElementsEqual(int i, int[] nums) {
        return nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2];
    }

    boolean isThreeConsEqual(int i, int[] nums) {
        return (nums[i] == (nums[i - 1] + 1)) && (nums[i - 1] == (nums[i - 2] + 1));
    }
}
