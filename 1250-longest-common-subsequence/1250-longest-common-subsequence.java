class Solution {
    Integer dp[][];

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new Integer[n][m];
        return recur(0, 0, text1, text2);
    }

    int recur(int i, int j, String s1, String s2) {
        if (i >= s1.length()) {
            return 0;
        }
        if (j >= s2.length()) {
            return 0;
        }
        if (dp[i][j] != null) return dp[i][j];

        int left = 0, right = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            left = 1 + recur(i + 1, j + 1, s1, s2);
        } else right = Math.max(recur(i + 1, j, s1, s2), recur(i, j + 1, s1, s2));
        dp[i][j] = Math.max(left, right);
        return dp[i][j];
    }
}
