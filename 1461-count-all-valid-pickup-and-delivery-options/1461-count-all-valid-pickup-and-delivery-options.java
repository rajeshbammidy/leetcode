class Solution {

    public int countOrders(int n) {
        long slots = n * 2;
        long res = 1;
        long mod = (long) (1e9 + 7);
        while (slots > 0) {
            long validArrangements = slots * (slots - 1) / 2;
            res = (res % mod * validArrangements % mod) % mod;
            slots -= 2;
        }
        return (int) ((res) % mod);
    }
}
