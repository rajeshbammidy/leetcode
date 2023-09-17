class Solution {
    Integer dp[][];

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new Integer[m][n];
        return recur(0, 0, word1, word2);
    }

    int recur(int i, int j, String word1, String word2) {
        if (i >= word1.length() && j >= word2.length()) {
            return 0;
        }
        if (i >= word1.length()) {
            return word2.length() - j;
        }
        if (j >= word2.length()) {
            return word1.length() - i;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = recur(i + 1, j + 1, word1, word2);
        } else {
            //delete
            int del = 1 + recur(i + 1, j, word1, word2);
            // replace
            int rep = 1 + recur(i + 1, j + 1, word1, word2);
            //insert
            int ins = 1 + recur(i, j + 1, word1, word2);
            return dp[i][j] = Math.min(Math.min(del, rep), ins);
        }
    }
}
