class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += (gas[i] - cost[i]);
        }
        if (totalSum < 0) return -1;
        int startIndex = -1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            sum += diff;
            if (sum < 0) {
                sum = 0;
                startIndex = -1;
            } else {
                if (startIndex == -1) {
                    startIndex = i;
                }
            }
        }
        return startIndex;
    }
}
