    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int dp[] = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                int leftv = 0, rightv = 0;

                if ((i - 1) < 0 || ratings[i - 1] >= ratings[i]) {
                    leftv = Integer.MIN_VALUE;
                } else {
                    leftv = dp[i - 1];
                }


                if ((i + 1) == n || ratings[i + 1] >= ratings[i]) {
                    rightv = Integer.MIN_VALUE;
                } else {
                    rightv = dp[i + 1];
                }

                leftv = Math.max(leftv, rightv);
                if (leftv != Integer.MIN_VALUE)
                    dp[i] = leftv + 1;
            }

            for (int i = n - 2; i >=0; i--) {
                if ((i-1>=0) && ratings[i - 1] < ratings[i] && dp[i - 1] >= dp[i]) {
                    dp[i] = dp[i - 1] + 1;
                }
                if (ratings[i + 1] < ratings[i] && dp[i + 1] >= dp[i]) {
                    dp[i] = dp[i + 1] + 1;
                }
            }
            System.out.println(Arrays.toString(dp));
            int sum = 0;
            for (int x : dp) sum += x;
            return sum;
        }
    }