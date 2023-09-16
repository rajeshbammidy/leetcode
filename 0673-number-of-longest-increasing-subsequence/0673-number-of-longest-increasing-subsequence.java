class Solution {

    /**
    Take away is: If you are reaching j in n ways, & if you are going from j to i.You will also will be able to reach i in n ways.
    * */

    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int count[] = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int n = nums.length;
        int LIS = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                    LIS = Math.max(LIS, dp[i]);
                }
            }
        }
        int res = 0;
        System.out.println(LIS);
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));
        for (int i = 0; i < n; i++) {
            if (dp[i] == LIS) res += count[i];
        }
        return res;
    }
}
