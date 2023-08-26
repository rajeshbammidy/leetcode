class Solution {
    private HashMap<String, Integer> map;

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n == 0) return 0;
        map = new HashMap<>();
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        return recur(-1, 0, pairs, n);
    }

    int recur(int prevIndex, int currentIndex, int pairs[][], int n) {
        if (currentIndex >= n) return 0;
        String key = currentIndex + "";
        if (map.containsKey(key)) return map.get(key);
        int take = 0;
        int notake = 0;
        if (prevIndex == -1 || pairs[prevIndex][1] < pairs[currentIndex][0]) {
            take = 1 + recur(currentIndex, currentIndex + 1, pairs, n);
        }
        notake = recur(prevIndex, currentIndex + 1, pairs, n);
        map.put(key, Math.max(take, notake));
        return Math.max(take, notake);
    }
}
