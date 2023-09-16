class Solution {

    static class Pair {
        int index;
        int value;

        Pair(int i, int v) {
            index = i;
            value = v;
        }
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(find(nums, 0, n - 1), find(nums, 1, n));
    }

    int find(int nums[], int start, int n) {
        int dp[] = new int[n];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start + 1], dp[start]);
        for (int i = start + 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
