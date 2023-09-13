class Solution {

    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int x : nums) {
            curSum += x;
            sum = Math.max(sum, curSum);
            if (curSum < 0) curSum = 0;
        }
        return sum;
    }
}
