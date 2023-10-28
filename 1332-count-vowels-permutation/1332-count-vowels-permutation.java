class Solution {
    int n;
    long mod = (long) ((1e9) + 7);

    HashMap<String, Long> map;

    public int countVowelPermutation(int n) {
        this.n = n;
        map = new HashMap<>();
        long ans = recur(1, 'a') + recur(1, 'e') + recur(1, 'i') + recur(1, 'o') + recur(1, 'u');
        ans %= mod;
        return (int) (ans);
    }

    long recur(int len, char ch) {
        if (len >= n) {
            return 1;
        }
        String key = len + "#" + ch;
        if (map.get(key) != null) return map.get(key);
        long res = 0;
        if (ch == 'a') {
            res = recur(len + 1, 'e');
        } else if (ch == 'e') {
            res = recur(len + 1, 'a') + recur(len + 1, 'i');
        } else if (ch == 'i') {
            res = recur(len + 1, 'a') + recur(len + 1, 'e') + recur(len + 1, 'o') + recur(len + 1, 'u');
        } else if (ch == 'o') {
            res = recur(len + 1, 'i') + recur(len + 1, 'u');
        } else {
            res = recur(len + 1, 'a');
        }
        map.put(key, res % mod);
        return map.get(key);
    }
}
