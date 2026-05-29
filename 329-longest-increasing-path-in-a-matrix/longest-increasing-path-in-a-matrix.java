class Solution {
    static int m;
    static int n;
    static int[][] dir = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int[][] len;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] len = new int[m][n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(max, dfs(i, j, matrix, len));
            }
        }
        return max;
    }

    public int dfs(int i, int j, int[][] matrix, int[][] len){
        int maxL = 1;
        if(len[i][j] != 0){
            return Math.max(maxL, len[i][j]);
        }
        for(int k = 0; k < 4; k++){
            int ni = i + dir[0][k];
            int nj = j + dir[1][k];
            if(ni >= 0 && nj >= 0 && ni < m && nj < n && matrix[i][j] < matrix[ni][nj]){
                maxL = Math.max(maxL, 1 + dfs(ni, nj, matrix, len));
            }
        }
        return len[i][j] = maxL;
    }
}