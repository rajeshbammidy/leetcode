class Solution {

    public int jump(int[] nums) {
        int maxLen = 0;
        int n = nums.length;
        if (n == 1) return 0;
        int i = 0;
        int range = i + nums[i];
        int maxRange = range;
        int count = 1;
        while (i <= range && i < n) {
            maxRange = Math.max(maxRange, i + nums[i]);
            if (i == range && i != (n - 1)) {
                count++;
                range = maxRange;
            }
            i++;
        }
        return count;
    }
}
