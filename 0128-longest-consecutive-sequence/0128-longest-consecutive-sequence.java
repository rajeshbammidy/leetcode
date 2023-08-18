class Solution {

    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int x : nums) set.add(x);
        int count = 1;
        for (int x : nums) {
            if (set.contains(x - 1)) continue;
            int v = x;
            int max = 1;
            while (set.contains(++v)) max++;
            count = Math.max(count, max);
        }
        return count;
    }
}
