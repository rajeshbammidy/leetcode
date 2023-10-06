class Solution {
    private HashMap<String, Integer> map;

    public int integerBreak(int n) {
        map = new HashMap<>();
        return recur(0, 1, n);
    }

    int recur(int sum, int i, int n) {
        String key = i + "#" + sum;
        if (sum == n) return 1;
        if (i == n || sum > n) return -1;
        if (map.containsKey(key)) return map.get(key);
        int take = 0;
        int notTake = 0;
        if (i <= n) {
            take = i * recur(sum + i, i, n);
        }
        notTake = recur(sum, i + 1, n);
        map.put(key, Math.max(take, notTake));
        return Math.max(take, notTake);
    }
}
