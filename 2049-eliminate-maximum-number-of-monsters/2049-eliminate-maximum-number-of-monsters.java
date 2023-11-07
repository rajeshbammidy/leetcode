class Solution {

    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>(
            (a, b) -> {
                return (int) (a - b);
            }
        );
        int len = dist.length;
        for (int i = 0; i < len; i++) {
            minHeap.add(Math.ceil(dist[i] * 1.0 / speed[i]));
        }
        int count = 1;
        double lastElapsed = 1;
        minHeap.poll();

        while (!minHeap.isEmpty()) {
            if (lastElapsed < minHeap.peek()) {
                minHeap.poll();
                lastElapsed++;
                count++;
            } else {
                return count;
            }
        }
        return count;
    }
}
