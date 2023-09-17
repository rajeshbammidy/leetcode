class Solution {
    Integer dp[][];

    public int minCut(String s) {
        int n = s.length();
        dp = new Integer[n][n];
        return recur(0, s.length() - 1, s);
    }

    boolean isPalindrome(int i, int j, String str) {
        while (i <= j && i < str.length()) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    int recur(int i, int j, String str) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (isPalindrome(i, j, str)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int s = i; s < j; s++) {
            if (isPalindrome(i, s, str)) {
                min = Math.min(1 + recur(s + 1, j, str), min);
            }
        }
        return dp[i][j] = min;
    }
}
