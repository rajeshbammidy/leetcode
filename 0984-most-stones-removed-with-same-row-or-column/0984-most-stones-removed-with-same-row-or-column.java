class Solution {
    /**
     * Idea:
     * Find all the elements that belongs to the group ie.. all the elements in the group should
     * match with other element x or y value.
     * We can do the above by doing a dfs, which will help us find all the possible pairs
     * which have identical x or y values.
     *
     * Once the groups are formed we cant delete the  group head,except that we can delete the rest of the element
     */

    HashSet<Integer> visited;

    public int removeStones(int[][] stones) {
        int m = stones.length;
        visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited.contains(i)) {
                dfs(stones, i, stones[i][0], stones[i][1]);
                count++;
            }

        }
        return m - count;


    }

    private void dfs(int[][] stones, int i, int x, int y) {
        visited.add(i);
        for (int j = 0; j < stones.length; j++) {
            if (!visited.contains(j) && (stones[j][0] == x || stones[j][1] == y)) {
                dfs(stones, j, stones[j][0], stones[j][1]);
            }

        }
    }
}