class Solution {

    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int beg = 0;
        int end = n;
        while (beg <= end) {
            int mid = beg + ((end - beg) >> 1);
            if (((mid - 1) < 0 || nums[mid - 1] > nums[mid]) && ((mid + 1 > n) || (nums[mid] < nums[mid + 1]))) return nums[mid]; else if (nums[mid] < nums[end]) end--; else beg++;
        }
        return -1;
    }
}
