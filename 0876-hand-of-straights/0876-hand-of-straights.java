class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int x : hand) {
            map.putIfAbsent(x, 0);
            map.put(x, map.get(x) + 1);
        }
        minHeap.addAll(map.keySet());
        while (!minHeap.isEmpty()) {
            int count = 0;
            Deque<Integer> queue = new ArrayDeque<>();
            while (queue.size() != groupSize && !minHeap.isEmpty()) {
                int element = minHeap.poll();
                if (!queue.isEmpty() && queue.getLast() + 1 != element) return false;
                queue.add(element);
                map.put(element, map.get(element) - 1);
            }
            if (queue.size() != groupSize) {
                return false;
            }
            for (int x : queue) {
                if (map.get(x) > 0) minHeap.add(x);
            }
        }
        return true;
    }
}
