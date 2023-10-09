class Solution {
    Long dp[][];

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        dp = new Long[m][n];
        return (int) recur(0, 0, nums1, nums2);
    }

    long recur(int i, int j, int nums1[], int nums2[]) {
        int m = nums1.length;
        int n = nums2.length;
        if (i >= m || j >= n) return Integer.MIN_VALUE;
        if (dp[i][j] != null) return dp[i][j];

        long product = nums1[i] * 1L * nums2[j] * 1L;
        long take = Math.max(nums1[i] * nums2[j] + recur(i + 1, j + 1, nums1, nums2), product);
        long noTake = Math.max(recur(i + 1, j, nums1, nums2), recur(i, j + 1, nums1, nums2));
        return dp[i][j] = Math.max(take, noTake);
    }
}
