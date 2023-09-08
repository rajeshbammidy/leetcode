class Solution {

    public int reverse(int x) {
        if (x == 0) return 0;
        long num = 0;
        int sign = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        while (x > 0) {
            int cd = x % 10;
            x = x / 10;
            num = num * 10 + cd;
        }
        num *= sign;
        if (num >= Integer.MAX_VALUE || num <= Integer.MIN_VALUE) return 0;
        return (int) num;
    }
}
