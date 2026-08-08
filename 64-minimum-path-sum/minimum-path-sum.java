class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, grid, dp);
    }

    int solve(int i, int j, int[][] grid, int[][] dp){
        if(i >= grid.length ||j >= grid[0].length){
            return (int) 1e9;
        }
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = grid[i][j] + solve(i + 1, j, grid, dp);
        int right = grid[i][j] + solve(i, j + 1, grid, dp);
        return dp[i][j] = Math.min(down, right);
    }
}