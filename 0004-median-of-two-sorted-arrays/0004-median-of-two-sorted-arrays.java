class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = nums1.length + nums2.length;
        int half = (int) Math.ceil(n * 1.0 / 2);
        int alen = nums1.length;
        int blen = nums2.length;
        //System.out.println(blen);
        if (alen == 0) {
            if ((blen & 1) == 0) {
                int left = nums2[(blen / 2) - 1];
                int right = nums2[(blen / 2)];
                return ((double) left + right) / 2;
            } else {
                return (double) (nums2[blen / 2]);
            }
        }

        int beg = 0;
        int end = alen - 1;

        boolean flag = true;
        while (flag) {
            int mid = (int) (beg + ((double) (end - beg)) / 2);
             if (end < 0) mid = -1;
            System.out.println(mid);
            int bmid = half - mid - 2;
            int aLeft = (mid) < 0 ? Integer.MIN_VALUE : nums1[mid];
            int aRight = (mid + 1) >= alen ? Integer.MAX_VALUE : nums1[mid + 1];
            int bLeft = (bmid) < 0 ? Integer.MIN_VALUE : nums2[bmid];
            int bRight = (bmid + 1) >= blen ? Integer.MAX_VALUE : nums2[bmid + 1];

            if (aLeft <= bRight && aRight >= bLeft) {
                if ((n & 1) == 0) {
                    return ((double) Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
                } else {
                    return (double) Math.max(aLeft, bLeft);
                }
            } else if (aLeft > bRight) end = mid - 1; else beg = mid + 1;
        }
        return (double) -1;
    }
}
