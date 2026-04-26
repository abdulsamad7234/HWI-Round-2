class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] check = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    check[i][j] = true;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0 && check[i][j] == true){
                    setRowZero(i, matrix);
                    setColumnZero(j, matrix);
                }
            }
        }
    }

    public void setRowZero(int i, int[][] matrix){
        for(int j = 0; j < matrix[0].length; j++){
            matrix[i][j] = 0;
        }
    }
    public void setColumnZero(int j, int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            matrix[i][j] = 0;
        }
    }
}