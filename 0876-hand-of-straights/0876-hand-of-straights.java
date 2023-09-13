class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //get the frequencies
        for (int x : hand) {
            map.putIfAbsent(x, 0);
            map.put(x, map.get(x) + 1);
        }
        //add the keys into minHeap
        minHeap.addAll(map.keySet());

        while (!minHeap.isEmpty()) {
            int count = 0;
            //Deque to check the consectiveness
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
            //add the elements back into minHeap
            for (int x : queue) {
                if (map.get(x) > 0) minHeap.add(x);
            }
        }
        return true;
    }
}
