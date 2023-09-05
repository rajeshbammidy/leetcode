class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums;
        int res[] = new int[n];
        int pre = 1;
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            pre *= (nums[i - 1]);
            res[i] = pre;
        }
        int post = 1;
        for (int i = n - 2; i >= 0; i--) {
            post *= (nums[i + 1]);
            res[i] *= post;
        }
        return res;
    }
}
