class Solution {
    int dirx[] = { -1, 0, 1, 0 };
    int diry[] = { 0, -1, 0, 1 };

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        //first row
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = '.';
                queue.add(new Pair<Integer, Integer>(0, i));
            }
        }
        //first col
        for (int i = 1; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '.';
                queue.add(new Pair<Integer, Integer>(i, 0));
            }
        }

        //last row
        for (int i = 1; i < n; i++) {
            if (board[m - 1][i] == 'O') {
                board[m - 1][i] = '.';
                queue.add(new Pair<Integer, Integer>(m - 1, i));
            }
        }

        //last col
        for (int i = 1; i < m - 1; i++) {
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = '.';
                queue.add(new Pair<Integer, Integer>(i, n - 1));
            }
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int cx = pair.getKey();
            int cy = pair.getValue();
            for (int i = 0; i < dirx.length; i++) {
                int nx = cx + dirx[i];
                int ny = cy + diry[i];
                if (isValid(nx, ny, m, n) && board[nx][ny] == 'O') {
                    queue.add(new Pair<Integer, Integer>(nx, ny));
                    board[nx][ny] = '.';
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
