class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] position = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    position[i][j] = 1;
                    int row = i;
                    while(row >= 0){
                        position[row][j] = 1;
                        row--;
                    }
                    row = i;
                    while(row < m){
                        position[row][j] = 1;
                        row++;
                    }
                    int col = j;
                    while(col >= 0){
                        position[i][col] = 1;
                        col--;
                    }
                    col = j;
                    while(col < n){
                        position[i][col] = 1;
                        col++;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(position[i][j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}