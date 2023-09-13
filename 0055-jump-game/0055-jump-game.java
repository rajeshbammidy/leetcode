class Solution {

    public boolean canJump(int[] nums) {
        int maxLen = 0;
        int n = nums.length;
        int i = 0;
        int range = i + nums[i];
        int maxRange = range;
        while (i <= range && i < n) {
            maxRange = Math.max(maxRange, i + nums[i]);
            if (i == range) {
                range = maxRange;
            }
            i++;
        }
        return i >= n;
    }
}
