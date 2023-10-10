class Solution {

    /**
    * We know that max - min = n-1
    where n is the len of the array
     */
    public int minOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>(set);
        list.sort(null);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            int maxElement = x + n;
            int index = Collections.binarySearch(list, maxElement);
            if (index < 0) index = Math.abs(index + 1);
            int unqElements = index - i;
            ans = Math.min(ans, n - unqElements);
        }

        return ans;
    }
}
