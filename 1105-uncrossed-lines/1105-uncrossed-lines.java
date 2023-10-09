class Solution {
    Integer dp[][];

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        dp = new Integer[m][n];
        return recur(0, 0, nums1, nums2);
    }

    int recur(int i, int j, int nums1[], int nums2[]) {
        int m = nums1.length;
        int n = nums2.length;
        if (i >= m || j >= n) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int take = 0;
        if (nums1[i] == nums2[j]) {
            take = 1 + recur(i + 1, j + 1, nums1, nums2);
        }
        int noTake = Math.max(recur(i + 1, j, nums1, nums2), recur(i, j + 1, nums1, nums2));
        return dp[i][j] = Math.max(take, noTake);
    }
}
