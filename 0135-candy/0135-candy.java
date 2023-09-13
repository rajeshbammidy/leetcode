class Solution {
     public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        Arrays.fill(candies, 1);
        int sum = candies.length;
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                sum -= candies[i];
                sum += (candies[i - 1] + 1);
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = candies.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
                sum -= candies[i - 1];
                sum += (candies[i] + 1);
                candies[i-1] = (candies[i] + 1);
            }
        }
        return sum;

    }
}