class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int x : nums) {
            if (pq.size() < k) pq.add(x); else if (x > pq.peek()) {
                pq.poll();
                pq.add(x);
            }
        }
    }

    public int add(int val) {
        if (pq.size() < k) pq.add(val);
        else if (val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
