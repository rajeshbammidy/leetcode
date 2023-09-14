class Solution {

    static class Triplet {
        int first;
        int second;
        int third;

        Triplet(int a, int b, int c) {
            first = a;
            second = b;
            third = c;
        }
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        ArrayList<Triplet> list = new ArrayList<>();
        for (int trplet[] : triplets) {
            if (trplet[0] <= target[0] && trplet[1] <= target[1] && trplet[2] <= target[2]) {
                list.add(new Triplet(trplet[0], trplet[1], trplet[2]));
            }
        }
        boolean ffound = false, sfound = false, tfound = false;
        for (Triplet tplt : list) {
            if (tplt.first == target[0]) ffound = true;
            if (tplt.second == target[1]) sfound = true;
            if (tplt.third == target[2]) tfound = true;
        }
        return ffound && sfound && tfound;
    }
}
