class Solution {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            if ((i - 1 >= 0) && ratings[i - 1] < ratings[i]) dp[i] = dp[i - 1] + 1;
        }
        System.out.println(Arrays.toString(dp));
        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 < n && ratings[i + 1] < ratings[i]) dp[i] = Math.max(dp[i], dp[i + 1] + 1);
        }
        System.out.println(Arrays.toString(dp));
        int sum = 0;
        for (int x : dp) sum += x;
        return sum;
    }
}
