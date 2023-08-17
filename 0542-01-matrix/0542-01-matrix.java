class Solution {

    static class Node {
        Pair<Integer, Integer> pair;
        int distance;

        Node(Pair<Integer, Integer> pair, int distance) {
            this.pair = pair;
            this.distance = distance;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    visited.add(pair);
                    Node node = new Node(pair, 0);
                    queue.add(node);
                }
            }
        }

        int dirx[] = { -1, 0, 1, 0 };
        int diry[] = { 0, -1, 0, 1 };
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dirx[i] + node.pair.getKey();
                int ny = diry[i] + node.pair.getValue();
                if (isValid(nx, ny, n, m) && mat[nx][ny] != 0 && !visited.contains(new Pair(nx, ny))) {
                    mat[nx][ny] = node.distance + 1;
                    visited.add(new Pair(nx, ny));
                    queue.add(new Node(new Pair(nx, ny), node.distance + 1));
                }
            }
        }
        return mat;
    }

    boolean isValid(int nx, int ny, int n, int m) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}
