class Solution {

    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int x : position) {
            if ((x & 1) == 0) even++; else odd++;
        }
        return Math.min(even, odd);
    }
}
