class Solution {

    /**
    * If there are n order there will be 2n slots
    * lets say we have n=2, which means we have P1,P2,D1,D2;
    and we have fours slots _,_,_,_ so lets take P1,D1 and arrange them in 4 slots
    P1 can be arrange in 4 ways and D1 can be arranged in 3 ways in total 4*3 ways,but 
    in half of the ways D1 would always come before P1 so we do 4*3/2 which will give valid arrangements.
    * */

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
