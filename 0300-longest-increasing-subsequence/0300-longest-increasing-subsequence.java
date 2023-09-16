class Solution {

    /***
    * Note: At any instance dp array might not hold the exact increasing subsequence.By using the below approach we just trying keep the size till i^th index of nums.
    Since we only care about the subsequnce it would get add at the end, we dont have to worry about the deletions in between.
     */

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int index = Collections.binarySearch(dp, nums[i]);
            index = index < 0 ? Math.abs(index + 1) : index;
            if (index >= dp.size()) {
                dp.add(nums[i]);
            } else {
                dp.set(index, nums[i]);
            }
        }
        return dp.size();
    }
}
