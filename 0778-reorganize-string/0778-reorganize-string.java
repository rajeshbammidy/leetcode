class Solution {

    public String reorganizeString(String s) {
        if (s.isEmpty()) return "";

        PriorityQueue<Pair<Character, Integer>> minHeap = new PriorityQueue<>(
            new Comparator<Pair<Character, Integer>>() {

                public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                   return o2.getValue().compareTo(o1.getValue());
                }
            }
        );
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            minHeap.add(new Pair<Character, Integer>(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();

        while (!minHeap.isEmpty()) {
            if (sb.length() == 0) {
                Pair<Character, Integer> pair = minHeap.poll();
                sb.append(pair.getKey());
                if (pair.getValue() > 1) minHeap.add(new Pair<Character, Integer>(pair.getKey(), pair.getValue() - 1));
            } else {
                Pair<Character, Integer> pair1 = minHeap.poll();
                if (sb.charAt(sb.length() - 1) == pair1.getKey()) {
                    if (minHeap.isEmpty()) return "";
                    Pair<Character, Integer> pair2 = minHeap.poll();
                    sb.append(pair2.getKey());
                    if (pair2.getValue() > 1) minHeap.add(new Pair<Character, Integer>(pair2.getKey(), pair2.getValue() - 1));
                    minHeap.add(pair1);
                } else {
                    sb.append(pair1.getKey());
                    if (pair1.getValue() > 1) minHeap.add(new Pair<Character, Integer>(pair1.getKey(), pair1.getValue() - 1));
                }
            }
        }
        return sb.toString();
    }
}
