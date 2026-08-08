class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            Arrays.fill(dp[i], 200);
        }
        for(int j = 0; j < matrix.length; j++){
            ans = Math.min(ans, solve(0, j, matrix, dp));
        }
        return ans;
    }

    int solve(int i, int j, int[][] grid, int[][] dp){
        if(j < 0 || j >= grid[0].length){
            return (int) 1e9;
        }
        if(i == grid.length){
            return 0;
        }
        if(dp[i][j] != 200){
            return dp[i][j];
        }
        int leftD = grid[i][j] + solve(i + 1, j - 1, grid, dp);
        int rightD = grid[i][j] + solve(i + 1, j + 1, grid, dp);
        int down = grid[i][j] + solve(i + 1, j, grid, dp);
        return dp[i][j] = Math.min(leftD, Math.min(rightD, down));
    }
}