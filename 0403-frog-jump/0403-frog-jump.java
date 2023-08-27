class Solution {
    HashMap<String, Boolean> map;

    public boolean canCross(int[] stones) {
        map = new HashMap<>();
        int n = stones.length;
        int index = 1;
        return recur(stones, 1, 1, 0);
    }

    boolean recur(int[] stones, int i, int d, int prev) {
        if (i >= stones.length) {
            return false;
        }
        int currentDistance = stones[i] - stones[prev];
        if (i == (stones.length - 1) && currentDistance == d) {
            return true;
        }
        String key = i + "#" + d+"#"+prev;
        if(map.containsKey(key))return map.get(key);

        boolean opt1 = false, opt2 = false, opt3 = false, opt4 = false;

        if (currentDistance == d) {
            opt1 = recur(stones, i + 1, d, i);
            opt2 = recur(stones, i + 1, d - 1, i);
            opt3 = recur(stones, i + 1, d + 1, i);
        } else if (currentDistance > d) {
            return false;
        } else {
            //if distance is greater
            opt4 = recur(stones, i + 1, d, prev);
        }
        boolean result = opt1 | opt2 | opt3 | opt4;
        map.put(key, result);
        return result;
    }
}
