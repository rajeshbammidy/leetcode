class Solution {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int element = nums[i];
            if (nums[Math.abs(element)] < 0) return Math.abs(element);
            nums[Math.abs(element)] = -1 * nums[Math.abs(element)];
        }
        return -1;
    }
}
