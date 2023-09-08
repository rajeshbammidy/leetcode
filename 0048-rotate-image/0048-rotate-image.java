class Solution {
    public void rotate(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                int x=matrix[i][j];
               matrix[i][j]=matrix[j][i];
               matrix[j][i]=x;
            }
        }

      for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                int x= matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=x;
            }


      }
        
    }
}