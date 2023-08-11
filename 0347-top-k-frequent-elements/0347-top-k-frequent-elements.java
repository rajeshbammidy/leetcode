class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //Get the frequencies
        for (int x : nums) {
            map.putIfAbsent(x, 0);
            map.put(x, map.get(x) + 1);
        }
        //minheap based on frequencies
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(new Pair(entry.getKey(), entry.getValue()));
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.add(new Pair(entry.getKey(), entry.getValue()));
            }
        }
        int ans[] = new int[minHeap.size()];
        int i = 0;
        while (!minHeap.isEmpty()) {
            ans[i++] = minHeap.poll().getKey();
        }
        return ans;
    }
}
