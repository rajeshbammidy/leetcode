class SeatManager {
    PriorityQueue<Integer> minHeap;
    HashSet<Integer> set;

    public SeatManager(int n) {
        set = new HashSet<Integer>();
        minHeap = new PriorityQueue<Integer>();
        for (int i = 1; i <= n; i++) minHeap.add(i);
    }

    public int reserve() {
        int value = minHeap.poll();
        set.add(value);
        return value;
    }

    public void unreserve(int seatNumber) {
        set.remove(seatNumber);
        minHeap.add(seatNumber);
    }
}
/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
