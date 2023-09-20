class Solution {
    private HashMap<String, Integer> map;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        map = new HashMap<>();
        return recur(0, prices, n, k, true);
    }

    int recur(int idx, int[] prices, int n, int k, boolean isBuy) {
        String key = idx + "#" + k + "#" + isBuy;
        if (k == 0) return 0;
        if (idx == n) return 0;
        if (map.containsKey(key)) return map.get(key);
        int value;
        if (isBuy) {
            value = Math.max(recur(idx + 1, prices, n, k, false) - prices[idx], recur(idx + 1, prices, n, k, true));
        } else {
            value = Math.max(recur(idx + 1, prices, n, k - 1, true) + prices[idx], recur(idx + 1, prices, n, k, false));
        }
        map.put(key, value);
        return map.get(key);
    }
}
