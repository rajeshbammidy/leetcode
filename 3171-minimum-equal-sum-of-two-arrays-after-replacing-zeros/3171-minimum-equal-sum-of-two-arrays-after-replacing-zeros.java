class Solution {

    public long minSum(int[] nums1, int[] nums2) {
        long smSum = 0;
        long gtSum = 0;
        int gtz = 0, stz = 0;
        for (int x : nums1) {
            gtSum += x;
            if (x == 0) gtz++;
        }
        for (int x : nums2) {
            smSum += x;
            if (x == 0) stz++;
        }

        if (gtSum < smSum) {
            long temp = gtSum;
            gtSum = smSum;
            smSum = temp;

            int tz = gtz;
            gtz = stz;
            stz = tz;
        }
        System.out.println(gtSum + " " + smSum + " " + gtz + " " + stz);
        if (gtSum == smSum) {
            if ((gtz == 0 && stz != 0) || (gtz != 0 && stz == 0)) {
                return -1;
            } else if (gtz == 0 && stz == 0) return gtSum;
        }

        if ((gtSum + gtz < smSum + stz) && gtz == 0) return -1;
        if (stz != 0) return Math.max(gtz + gtSum, smSum + stz);
        return -1;
    }
}
