class Solution {

    /**
    * If the elements are sorted.
    1,2,4,8
    if 4%8 = 0 , then all the elements that divides 4 would also divides 8.
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 0;
        int maxLenIndex = 0;
        Arrays.sort(nums);
        HashMap<Integer, Integer> cToMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if ((dp[j] + 1) > dp[i]) {
                        dp[i] = dp[j] + 1;
                        if (maxLen < dp[i]) {
                            maxLen = dp[i];
                            maxLenIndex = i;
                        }
                        cToMap.put(i, j);
                    }
                }
            }
        }
        // System.out.println(maxLen);
        // System.out.println(cToMap);
        // System.out.println(Arrays.toString(dp));
        ArrayList<Integer> result = new ArrayList<>();
        int key = maxLenIndex;
        while (cToMap.containsKey(key)) {
            result.add(nums[key]);
            key = cToMap.get(key);
        }
        result.add(nums[key]);
        return result;
    }
}
