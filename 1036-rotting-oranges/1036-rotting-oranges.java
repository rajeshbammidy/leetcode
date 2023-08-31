class Solution {
    int dirx[] = { -1, 0, 1, 0 };
    int diry[] = { 0, -1, 0, 1 };

    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
       // if (m == 1 && n == 1 && grid[m - 1][n - 1] == 0) return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair<>(i, j));
                }
            }
        }
        int timer = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> p = queue.poll();
                int cx = p.getKey();
                int cy = p.getValue();
                for (int j = 0; j < dirx.length; j++) {
                    int nx = cx + dirx[j];
                    int ny = cy + diry[j];
                    if (isValid(nx, ny, m, n) && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.add(new Pair<>(nx, ny));
                    }
                }
            }
            timer++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return timer==-1?0:timer;
    }

    boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
