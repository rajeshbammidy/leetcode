class Solution {

    public int missingNumber(int[] arr) {
        int n = arr.length;
        int sum = n * (n + 1) / 2;
        int csum = 0;
        for (int x : arr) csum += x;
        return sum - csum;
    }
}
