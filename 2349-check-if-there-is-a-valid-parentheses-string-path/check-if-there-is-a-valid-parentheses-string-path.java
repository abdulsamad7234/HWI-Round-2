class Solution {
    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0] == ')'){
            return false;
        }

        Boolean dp[][][] = new Boolean[grid.length][grid[0].length][grid.length + grid[0].length];
        return solve(0, 0, 0, grid, dp);
    }

    boolean solve(int i, int j, int open, char[][] grid, Boolean dp[][][]){
        if(i >= grid.length || j >= grid[0].length){
            return false;
        }
        if(grid[i][j] == '('){
            open++;
        }else{
            open--;
        }

        if(i == grid.length - 1 && j == grid[0].length - 1){
            return open == 0;
        }

        if(open < 0){
            return false;
        }

        if(dp[i][j][open] != null){
            return dp[i][j][open];
        }

        boolean right = solve(i, j + 1, open, grid, dp);
        boolean down = solve(i + 1, j, open, grid, dp);

        return dp[i][j][open] = down || right;
    }
}