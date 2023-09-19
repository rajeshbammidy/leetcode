class Solution {
    /**
     * We know that we would require at-latest 1 health to go from a cell to another cell, which means the value in the cell must be greater than 1
     * to be alive.
     *
     * Keeping this in mind at each cell we should calculate what is the minimum energy that is required to a cell to enter the current cell.
     *
     * Lets consider the last cell of dungeon, if it positive which means we just need 1 minimum health for our knight to enter that cell.
     * If it is -ve we would require x+(value in the last cell)=1
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dungeon[i][j] = dungeon[i][j] < 0 ? Math.abs(dungeon[i][j]) + 1 : 1;
                    continue;
                }

                int right = Integer.MAX_VALUE;
                int bottom = Integer.MAX_VALUE;

                if (j + 1 < n) {
                    right = dungeon[i][j + 1] - dungeon[i][j];
                    if (right <= 0) right = 1;
                }
                if (i + 1 < m) {
                    bottom = dungeon[i + 1][j] - dungeon[i][j];
                    if (bottom <= 0) bottom = 1;
                }
                dungeon[i][j] = Math.min(right, bottom);
            }

        }
        return dungeon[0][0];

    }
}