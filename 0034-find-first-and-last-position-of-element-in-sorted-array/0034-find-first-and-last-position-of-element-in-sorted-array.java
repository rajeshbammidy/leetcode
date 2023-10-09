class Solution {

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int index = Arrays.binarySearch(nums, target);
        int leftIndex = index;
        int rightIndex = index;
        if (index < 0) return new int[] { -1, -1 };
        while (leftIndex > 0 && nums[leftIndex - 1] == target) leftIndex--;
        while (rightIndex < n - 1 && nums[rightIndex + 1] == target) rightIndex++;
        return new int[] { leftIndex, rightIndex };
    }
}
