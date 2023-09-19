class Solution {
    private HashMap<String, Integer> map;

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        map = new HashMap<>();
        int n = nums.length;
        return recur(0, nums, target, 0);
    }

    int recur(int idx, int nums[], int target, int cSum) {
        String key = idx + "#" + cSum;
        if (idx == nums.length) {
            if (target == cSum) {
                return 1;
            } else {
                return 0;
            }
        }
        if (map.containsKey(key)) return map.get(key);
        int value = recur(idx + 1, nums, target, cSum + nums[idx]) + recur(idx + 1, nums, target, cSum - nums[idx]);
        map.put(key, value);
        return value;
    }
}
