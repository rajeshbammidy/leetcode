class Solution {

    public int jump(int[] nums) {
        int maxJump = nums[0];
        int n = nums.length;
        int curI = 1;
        int jumps = 1;
        int curMaxJump = nums[0];
        while (curI < n) {
            if (maxJump >= n - 1) return jumps;
            if (curMaxJump < (curI + nums[curI])) {
                curMaxJump = curI + nums[curI];
            }
            if (curI == maxJump) {
                maxJump = curMaxJump;
                jumps++;
            }
            curI++;
        }
        return 0;
    }
}
