class Solution {

    /**
    
    Problem is an extended version of : https://leetcode.com/problems/search-in-rotated-sorted-array/

The catch here is when the array contains duplicates and the array is rotated, like in the following case
[1,2,1,1,1] - and here we have to search for the value 2;
The mid = 2, and arr[mid]==1
Though the left half sorted condition is true, it says that the value doesnt exists inside the left sorted half, so we will explore the right half which will never leads to the answer.

Therefore when ever we encounter arr[beg]==arr[mid]==arr[end] perform beg++,end--;
                                
     */

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int beg = 0;
        int end = n - 1;
        while (beg <= end) {
            int mid = beg + ((end - beg) >> 2);
            if (nums[mid] == target) return true;
            //handling the edge case
            if (nums[mid] == nums[beg] && nums[mid] == nums[end]) {
                beg = beg + 1;
                end = end - 1;
                continue;
            }
            //left half is sorted
            if (nums[mid] >= nums[beg]) {
                //target in the left sorted half.
                if (nums[mid] > target && nums[beg] <= target) end = mid - 1; else beg = mid + 1;
            } else {
                if (nums[mid] < target && nums[end] >= target) beg = mid + 1; else end = mid - 1;
            }
        }
        return false;
    }
}
