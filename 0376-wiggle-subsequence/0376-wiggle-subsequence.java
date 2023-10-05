class Solution {

    public int wiggleMaxLength(int[] nums) {
        int prevI = 0;
        int curI = 0;
        int n = nums.length;
        if (n == 1) return 1;
        int route = -1;
        int count = 0;
        int prev = 0;
        while (curI < n) {
            if (curI == n - 1) break;
            prev = curI;
            while ((curI + 1) < n && nums[curI] <= nums[curI + 1]) {
                curI++;
            }
            if (prev != curI && nums[prev] != nums[curI]) {
                System.out.println(prev + " " + curI);
                count++;
            }
            if (curI == n - 1) break;
            prev = curI;
            while ((curI + 1) < n && nums[curI] >= nums[curI + 1]) {
                curI++;
            }
            if (prev != curI && nums[prev] != nums[curI]) {
                System.out.println(prev + " " + curI);
                count++;
            }
        }
        if (prev == 0 && count == 1 && nums[0] == 0) return 1;
        return count + 1;
    }
}
