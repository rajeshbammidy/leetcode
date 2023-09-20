class Solution {

    public int minOperations(int[] nums, int x) {
        long sum = 0;
        int n = nums.length;
        int maxSubArrayLen = 0;
        for (int num : nums) sum += num;
        long diff = sum - x;
        if (diff == 0) return n;
        int start = 0, end = 0, idx = 0;
        long curSum = 0;
        while (end < n) {
            curSum += nums[end];
            //  System.out.println(curSum);
            while (curSum > diff && start <= end) {
                curSum -= nums[start++];
            }
            if (curSum == diff) {
                maxSubArrayLen = Math.max(end - start + 1, maxSubArrayLen);
            }
            end++;
        }

        return (maxSubArrayLen == 0) ? -1 : (n - maxSubArrayLen);
    }
}
