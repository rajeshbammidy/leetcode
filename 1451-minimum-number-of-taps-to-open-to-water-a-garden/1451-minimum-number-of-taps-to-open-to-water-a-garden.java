class Solution {

    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }
        System.out.println(Arrays.toString(arr));
        int end = 0, farCanReach = 0, ans = 0;
        int i = 0;
        while (i < arr.length && end < n) {
            ans++;
            while (i < arr.length && i <= end) {
                farCanReach = Math.max(farCanReach, arr[i++]);
            }
            if (end == farCanReach) return -1;
            end = farCanReach;
        }

        return ans;
    }
}
