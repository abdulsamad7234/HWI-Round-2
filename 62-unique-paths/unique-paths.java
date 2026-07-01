class Solution {
    static Integer[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else{
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    int left = (j > 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    int solve(int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return 0;
        }
        if(i == m - 1 && j == n - 1){
            return 1;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int right = solve(i, j + 1, m, n);
        int down = solve(i + 1, j, m, n);
        return dp[i][j] = right + down;
    }
}