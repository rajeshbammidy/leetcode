class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            int sum = 0 - nums[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int s = nums[start];
                int e = nums[end];
                if (s + e > sum) {
                    end--;
                } else if (s + e < sum) {
                    start++;
                } else {
                    while ((start + 1) < end && nums[start + 1] == s) {
                        start++;
                    }
                    while ((end - 1) > start && nums[end - 1] == e) {
                        end--;
                    }
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[i]);
                    temp.add(s);
                    temp.add(e);
                    if (!set.contains(temp)) result.add(temp);
                    set.add(temp);
                    start++;
                    end--;
                }
            }
        }
        return result;
    }
}
