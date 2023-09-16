class Solution {

    public int maxEnvelopes(int[][] envelopes) {
        //sort according to the x-cord.If x-cord are same sort the y-cords in desc
        Arrays.sort(
            envelopes,
            (
                (o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return -(o1[1] - o2[1]);
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            )
        );
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(envelopes[0][1]);
        /**
        Now that we know all the envelopes are sorted according to x-cords we want LIS of y-cords.
         */
        for (int i = 1; i < envelopes.length; i++) {
            int index = Collections.binarySearch(dp, envelopes[i][1]);
            index = index < 0 ? Math.abs((index + 1)) : index;
            if (index >= dp.size()) {
                dp.add(envelopes[i][1]);
            } else {
                dp.set(index, envelopes[i][1]);
            }
        }
        return dp.size();
    }

    private boolean canFit(int[] envelope, int[] envelope1) {
        return envelope[0] < envelope1[0] && envelope[1] < envelope1[1];
    }
}
