class Solution {

    int getPowerSum(int n) {
        int num = 0;
        while (n > 0) {
            int cd = n % 10;
            n /= 10;
            num += (cd * cd);
        }
        return num;
    }

    public boolean isHappy(int n) {
        int slow = getPowerSum(n);
        int fast = getPowerSum(n);
        fast = getPowerSum(fast);
        while (slow != fast) {
            slow = getPowerSum(slow);
            fast = getPowerSum(fast);
            fast = getPowerSum(fast);
        }
        if (slow == 1) return true;
        return false;
    }
}
