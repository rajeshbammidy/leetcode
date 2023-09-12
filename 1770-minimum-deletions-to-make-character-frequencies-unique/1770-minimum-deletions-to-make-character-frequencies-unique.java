class Solution {

    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : map.values()) {
            pq.add(x);
        }
        int prev = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            int current = pq.poll();
            if (prev != current) {
                prev = current;
            } else {
                count++;
                if ((current - 1) != 0) pq.add(current - 1);
            }
        }
        return count;
    }
}
