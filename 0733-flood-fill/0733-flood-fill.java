class Solution {
    int dirx[] = { -1, 0, 1, 0 };
    int diry[] = { 0, -1, 0, 1 };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        queue.add(new Pair<>(sr, sc));
        int orgColor = image[sr][sc];
        image[sr][sc] = color;
        if (orgColor == color) return image;

        while (!queue.isEmpty()) {
            int size = queue.size();
           // System.out.println(queue + " - " + Arrays.deepToString(image));
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> p = queue.poll();
                int cx = p.getKey();
                int cy = p.getValue();
                for (int j = 0; j < dirx.length; j++) {
                    int nx = cx + dirx[j];
                    int ny = cy + diry[j];
                    if (isValid(nx, ny, m, n) && image[nx][ny] == orgColor) {
                        image[nx][ny] = color;
                        queue.add(new Pair<>(nx, ny));
                    }
                }
            }
        }
        return image;
    }

    boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
