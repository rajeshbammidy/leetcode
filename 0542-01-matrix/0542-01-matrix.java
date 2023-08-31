class Solution {
    int dirx[] = { -1, 0, 1, 0 };
    int diry[] = { 0, -1, 0, 1 };

    public int[][] updateMatrix(int[][] mat) {
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        Queue<Pair<Integer[], Integer>> queue = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Pair<Integer[], Integer>(new Integer[] { i, j }, 0));
                    set.add(new Pair<Integer, Integer>(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair<Integer[], Integer> pair = queue.poll();
            int cx = pair.getKey()[0];
            int cy = pair.getKey()[1];
            int distance = pair.getValue();
            for (int i = 0; i < dirx.length; i++) {
                int nx = cx + dirx[i];
                int ny = cy + diry[i];
                if (isValid(nx, ny, m, n) && mat[nx][ny] != 0 && !set.contains(new Pair<>(nx, ny))) {
                    mat[nx][ny] = 1 + distance;
                    queue.add(new Pair<Integer[], Integer>(new Integer[] { nx, ny }, 1 + distance));
                    set.add(new Pair<Integer, Integer>(nx, ny));
                }
            }
        }
        return mat;
    }

    boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
