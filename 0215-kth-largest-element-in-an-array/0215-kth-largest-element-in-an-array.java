class Solution {

    public int findKthLargest(int[] nums, int k) {
        //Minheap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int element = nums[i++];
            if (pq.isEmpty() || pq.size() < k) {
                pq.add(element);
            } else {
                // if the peek is more than the current element, then ignore the current.
                if (pq.peek() < element) {
                    pq.poll();
                    pq.add(element);
                }
            }
        }
        return pq.peek();
    }
}
