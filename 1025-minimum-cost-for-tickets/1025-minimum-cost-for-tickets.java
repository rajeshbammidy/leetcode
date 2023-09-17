class Solution {
     Integer dp[];

    public int mincostTickets(int[] days, int[] costs) {
        int max = days[days.length - 1];
        int min = days[0];
        dp = new Integer[days.length];
        return getMinCost(0, days.length, days, costs);

    }

    private int getMinCost(int start, int end, int days[], int[] costs) {

        if (start == end) {
            return 0;
        }
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        if (dp[start] != null) return dp[start];

        int oneDayPass = costs[0] + getMinCost(start + 1, end, days, costs);
        int tempEnd = days[start] + 6;
        int i = start;
        while (i < end) {
            if (days[i] > tempEnd) break;
            i++;
        }
        int sevenDayPass = costs[1] + getMinCost(i, end, days, costs);
        tempEnd = days[start] + 29;
        i = start;
        while (i < end) {
            if (days[i] > tempEnd) break;
            i++;
        }
        int thirtyDayPass = costs[2] + getMinCost(i, end, days, costs);
        int min = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
        dp[start] = min;
        return min;

    }

}