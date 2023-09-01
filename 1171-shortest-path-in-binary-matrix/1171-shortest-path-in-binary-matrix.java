class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int m = grid.length - 1;
            int n = grid[0].length - 1;

            int xcords[] = {-1, -1, 0, 1, 1, 1, 0, -1};
            int ycords[] = {0, -1, -1, -1, 0, 1, 1, 1};

            Queue<Pair<Pair<Integer, Integer>, Integer>> queue = new LinkedList<>();
            HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
            if (grid[0][0] == 1) return -1;
            queue.add(new Pair<>(new Pair<>(0, 0), 1));
            visited.add(new Pair<>(0, 0));
            while (!queue.isEmpty()) {

                Pair<Pair<Integer, Integer>, Integer> currentPair = queue.poll();
                Pair<Integer, Integer> cords = currentPair.getKey();
                int currentDistance = currentPair.getValue();
                int curx = cords.getKey();
                int cury = cords.getValue();

                if (curx == m && cury == n) return currentDistance;

                for (int i = 0; i < xcords.length; i++) {

                    if ((curx + xcords[i] >= 0 && curx + xcords[i] <= m && (cury + ycords[i] >= 0 && cury + ycords[i] <= n)) && grid[curx + xcords[i]][cury + ycords[i]]==0) {
                        if (!visited.contains(new Pair<>(curx + xcords[i], cury + ycords[i]))) {
                            visited.add(new Pair<>(curx + xcords[i], cury + ycords[i]));
                            queue.add(new Pair<>(new Pair<>(curx + xcords[i], cury + ycords[i]), currentDistance + 1));
                        }

                    }

                }


            }
            return -1;
        }
}