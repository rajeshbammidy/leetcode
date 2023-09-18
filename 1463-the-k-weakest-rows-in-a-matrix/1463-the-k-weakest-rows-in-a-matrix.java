class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        );
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            minHeap.add(new int[] { i, count });
        }
        int res[] = new int[k];
        int i = 0;
        while (i < k) {
            res[i++] = minHeap.poll()[0];
        }
        return res;
    }
}
