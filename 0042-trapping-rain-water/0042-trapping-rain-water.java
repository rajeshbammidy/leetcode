class Solution {

    public int trap(int[] height) {
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        leftMax[0] = -1;
        rightMax[n - 1] = -1;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int ht = Math.min(leftMax[i], rightMax[i]);
            if (ht > height[i]) {
                totalWater += (ht - height[i]);
            }
        }
        return totalWater;
    }
}
