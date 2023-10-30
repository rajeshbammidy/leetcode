class Solution {

    public int[] sortByBits(int[] arr) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.getValue() == b.getValue()) {
                    return a.getKey() - b.getKey();
                }
                return a.getValue() - b.getValue();
            }
        );
        for (int x : arr) {
            pq.add(new Pair<Integer, Integer>(x, Integer.bitCount(x)));
        }
        int ans[] = new int[arr.length];
        int idx = 0;
        while (!pq.isEmpty()) {
            ans[idx++] = pq.poll().getKey();
        }
        return ans;
    }
}
