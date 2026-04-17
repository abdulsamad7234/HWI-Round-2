class Solution {
    static Integer[][][][] dp;
    public int cherryPickup(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length][grid.length][grid[0].length];
        int ans = solve(0, 0, 0, 0, grid);
        return (ans <= (int) -1e9) ? 0 : ans;
    }

    public int solve(int r1, int c1, int r2, int c2, int[][] grid){
        if(r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return (int) -1e9;
        }
        if(r1 == grid.length - 1 && r2 == grid.length - 1 && c1 == grid[0].length - 1 && c2 == grid.length - 1){
            return grid[r1][c1];
        }
        if(dp[r1][c1][r2][c2] != null){
            return dp[r1][c1][r2][c2];
        }
        int cherry = (r1 == r2 && c1 == c2) ? grid[r1][c1] : grid[r1][c1] + grid[r2][c2];
        int choice1 = solve(r1 + 1, c1, r2 + 1, c2, grid);
        int choice2 = solve(r1, c1 + 1, r2, c2 + 1, grid);
        int choice3 = solve(r1 + 1, c1, r2, c2 + 1, grid);
        int choice4 = solve(r1, c1 + 1, r2 + 1, c2, grid);
        int ans = Math.max(choice1, Math.max(choice2, Math.max(choice3, choice4)));
        return dp[r1][c1][r2][c2] = (ans <= (int) -1e9) ? (int) -1e9 : cherry + ans;
    }
}