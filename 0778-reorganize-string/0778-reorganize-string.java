class Solution {

    /**
    
    Intution: You have to sort <key,value> wrt values and take the highest freq character first. 
     */

    public String reorganizeString(String s) {
        if (s.isEmpty()) return "";

        // maxHeap to find the highest freq key
        PriorityQueue<Pair<Character, Integer>> maxHeap = new PriorityQueue<>(
            new Comparator<Pair<Character, Integer>>() {

                public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        );
        // map to store the key and freq's
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }
        // Add the pairs to maxHeap
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(new Pair<Character, Integer>(entry.getKey(), entry.getValue()));
        }

        // to store the string
        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            //if there is no prev character to compare
            if (sb.length() == 0) {
                Pair<Character, Integer> pair = maxHeap.poll();
                sb.append(pair.getKey());
                if (pair.getValue() > 1) maxHeap.add(new Pair<Character, Integer>(pair.getKey(), pair.getValue() - 1));
            } else {
                Pair<Character, Integer> pair1 = maxHeap.poll();
                if (sb.charAt(sb.length() - 1) == pair1.getKey()) {
                    if (maxHeap.isEmpty()) return "";
                    Pair<Character, Integer> pair2 = maxHeap.poll();
                    sb.append(pair2.getKey());
                    if (pair2.getValue() > 1) maxHeap.add(new Pair<Character, Integer>(pair2.getKey(), pair2.getValue() - 1));
                    maxHeap.add(pair1);
                } else {
                    sb.append(pair1.getKey());
                    if (pair1.getValue() > 1) maxHeap.add(new Pair<Character, Integer>(pair1.getKey(), pair1.getValue() - 1));
                }
            }
        }
        return sb.toString();
    }
}
