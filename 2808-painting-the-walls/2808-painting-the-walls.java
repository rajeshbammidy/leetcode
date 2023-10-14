class Solution {
    private HashMap<String, Long> map;

    public int paintWalls(int[] cost, int[] time) {
        map = new HashMap<>();
        int n = time.length;
        return (int) solve(0, cost, time, 0);
    }

    long solve(int idx, int cost[], int time[], int timer) {
        int n = cost.length;
        String key = idx + "#" + timer;
        if (timer >= n) return 0;
        if (idx >= n) {
            return Integer.MAX_VALUE;
        }
        if (map.containsKey(key)) return map.get(key);
        long takeTime = cost[idx] + solve(idx + 1, cost, time, timer + time[idx] + 1);
        long freeTime = solve(idx + 1, cost, time, timer);
        long value = Math.min(takeTime, freeTime);
        map.put(key, value);
        return value;
    }
}
