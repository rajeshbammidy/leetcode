class Solution {
    static Integer dp[][];

    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return findDistinctSubsequences(s, t, 0, 0);
    }

    private int findDistinctSubsequences(String s, String t, int i, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int value = 0;

        if (s.charAt(i) == t.charAt(j)) {
            value = findDistinctSubsequences(s, t, i + 1, j + 1);
        }
        int maxValue = value + findDistinctSubsequences(s, t, i + 1, j);
        dp[i][j] = maxValue;
        return maxValue;
    }
}
