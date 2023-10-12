/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length() - 1;
        int beg = 0;
        int end = length;
        int ans = -1;
        int mpeak = 0;
        //find the mountain peak
        while (beg <= end) {
            int mid = beg + ((end - beg) >> 1);
            int midElement = mountainArr.get(mid);
            if (mid - 1 >= 0 && mountainArr.get(mid - 1) < midElement && mid + 1 <= length && midElement > mountainArr.get(mid + 1)) {
                mpeak = mid;
                break;
            } else if (mid - 1 < 0 || mountainArr.get(mid - 1) < midElement) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        beg = 0;
        end = mpeak;
        ans = -1;
        //find the element on the left of mountain
        while (beg <= end) {
            int mid = beg + ((end - beg) >> 1);
            int midElement = mountainArr.get(mid);
            if (midElement == target) {
                ans = mid;
                end = mid - 1;
            } else if (midElement < target) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (ans != -1) return ans;
        beg = mpeak;
        end = length;
        //find the element on the right of mountain.
        while (beg <= end) {
            int mid = beg + ((end - beg) >> 1);
            int midElement = mountainArr.get(mid);
            if (midElement == target) {
                ans = mid;
                end = mid - 1;
            } else if (midElement < target) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return ans;
    }
}
