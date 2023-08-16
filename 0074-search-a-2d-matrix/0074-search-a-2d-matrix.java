class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int cr = 0;
        int cc = cols - 1;
        while (cr >= 0 && cr < rows && cc >= 0 && cc < cols) {
            if (matrix[cr][cc] == target) return true; else if (matrix[cr][cc] > target) {
                cc--;
            } else {
                cr++;
            }
        }
        return false;
    }
}
