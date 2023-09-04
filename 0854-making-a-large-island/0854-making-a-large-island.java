class Solution {
    int parent[];
    int size[];

    int find(int x) {
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    void unionBySize(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if (xp == yp) return;
        if (size[xp] < size[yp]) {
            parent[xp] = yp;
            size[yp] += size[xp];
        } else {
            parent[yp] = xp;
            size[xp] += size[yp];
        }
    }

    public int largestIsland(int[][] grid) {
        int dirx[] = { -1, 0, 1, 0 };
        int diry[] = { 0, -1, 0, 1 };
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        size = new int[m * n];
        Arrays.fill(size, 1);
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int parent = i * n + j;
                if (grid[i][j] == 1) {
                    for (int k = 0; k < dirx.length; k++) {
                        int nr = i + dirx[k];
                        int ny = j + diry[k];
                        if (isValid(nr, ny, m, n) && grid[nr][ny] == 1) {
                            int child = nr * n + ny;
                            unionBySize(parent, child);
                        }
                    }
                }
            }
        }

        int mx = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dirx[ind];
                    int newc = col + diry[ind];
                    if (isValid(newr, newc, m, n)) {
                        if (grid[newr][newc] == 1) {
                            components.add(find(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                for (Integer parents : components) {
                    sizeTotal += size[parents];
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }
        for (int cellNo = 0; cellNo < m * n; cellNo++) {
            mx = Math.max(mx, size[find(cellNo)]);
        }
        return mx;
    }

    boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
