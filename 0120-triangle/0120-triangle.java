class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(0));

        int col = 2;
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            int prevSize = dp.get(i - 1).size();
            for (int j = 0; j < col; j++) {
                int prevSame = (j >= prevSize) ? Integer.MAX_VALUE : dp.get(i - 1).get(j);
                int prevLeft = (j - 1 >= 0) ? dp.get(i - 1).get(j - 1) : Integer.MAX_VALUE;
                temp.add(Math.min(prevSame, prevLeft) + triangle.get(i).get(j));
            }
            dp.add(temp);
            col++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp.get(n - 1).get(i));
        }
        return min;
    }
}
