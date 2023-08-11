class Solution {

    /**
    Intution: We should always take the max freq character first and process it rather  than the other freq elements
    For example: A,A,A,B,B,C,C & n=1
    Process: BCBCA_A_A
    If we had taken the max freqed character at the first place
    ABCABCA
    ABACABC are the possible schedulings with no idle times, basically choosing the more
    frequed element would reduce the idle times.
    
    
     */
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        //store the freq of the character
        for (char ch : tasks) {
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }
        //create a maxHeap -- we have to process the max freqed element to reduce the idle time
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //Add the freq, we dont care about the key value
        maxHeap.addAll(map.values());
        //Once the max frequed element is taken from the maxHeap, reduce its freq and add it queue.
        //This queue will make sure to add the element back to queue at right time.
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int timer = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            timer += 1;
            if (!maxHeap.isEmpty()) {
                int charFreq = maxHeap.poll() - 1;
                if (charFreq != 0) queue.add(new Pair<Integer, Integer>(timer + n, charFreq));
            }
            if (!queue.isEmpty() && timer == (int) queue.peek().getKey()) {
                maxHeap.add(queue.poll().getValue());
            }
        }
        return timer;
    }
}
