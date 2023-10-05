class Solution {

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int count1 = 0;
        int count2 = 0;
        int num1 = -1;
        int num2 = -1;
        for (int x : nums) {
            if (num1 == x) {
                count1++;
            } else if (num2 == x) {
                count2++;
            } else if (count1 == 0) {
                num1 = x;
                count1++;
            } else if (count2 == 0) {
                num2 = x;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;

        int majority = (int) Math.floor(nums.length / 3.0);
        System.out.println(num1 + " " + num2 + " " + majority);
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (num1 == x) {
                count1++;
                if (count1 > majority) set.add(x);
            } else if (num2 == x) {
                count2++;
                if (count2 > majority) set.add(x);
            }
        }
        return new ArrayList<>(set);
    }
}
