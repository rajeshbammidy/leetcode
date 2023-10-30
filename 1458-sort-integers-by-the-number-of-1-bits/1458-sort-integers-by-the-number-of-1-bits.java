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
            int count = 0;
            int temp = x;
            while (x > 0) {
                if ((x & 1) > 0) {
                    count++;
                }
                x >>= 1;
            }
            pq.add(new Pair<Integer, Integer>(temp, count));
        }
        int ans[] = new int[arr.length];
        int idx = 0;
        while (!pq.isEmpty()) {
            ans[idx++] = pq.poll().getKey();
        }
        return ans;
    }
}
