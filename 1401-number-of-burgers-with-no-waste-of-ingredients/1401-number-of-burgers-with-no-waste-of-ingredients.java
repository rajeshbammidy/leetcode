class Solution {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices == 0 && cheeseSlices == 0) {
            res.add(0);
            res.add(0);
            return res;
        }
        if (cheeseSlices >= tomatoSlices || (tomatoSlices & 1) != 0) return res;
        int big = tomatoSlices / 2 - cheeseSlices;
        int small = cheeseSlices - big;
        if (big < 0 || small < 0) return res;
        res.add(big);
        res.add(small);
        return res;
    }
}
