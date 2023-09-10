class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int beg = 1;
        int end = (int) (1e9);
        while (beg <= end) {
            int k = beg + (end - beg) / 2;
            if (isValid(piles, k, h)) {
                end = k - 1;
            } else {
                beg = k + 1;
            }
        }
        return end + 1;
    }

    public boolean isValid(int piles[], int k, int h) {
        long hours = 0;
        for (int x : piles) {
            hours += (Math.ceil(x * 1.0 / k));
            if (hours > h) return false;
        }
        return true;
    }
}
