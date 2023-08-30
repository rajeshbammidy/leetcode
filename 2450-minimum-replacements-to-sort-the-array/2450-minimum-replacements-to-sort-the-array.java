class Solution {

    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int n = nums.length - 1;
        long prev = nums[n];
        int i = n - 1;
        while (i >= 0) {
            if (prev < nums[i]) {
                long parts = (long) Math.ceil(nums[i] * 1.0 / prev);
                ans += (parts - 1);
                prev = nums[i] / parts;
            } else {
                prev = nums[i];
            }
            i--;
        }
        return ans;
    }
}
