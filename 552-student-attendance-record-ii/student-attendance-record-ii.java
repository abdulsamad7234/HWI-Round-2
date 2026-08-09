class Solution {
    static int MOD = (int) 1e9 + 7;
    public int checkRecord(int n) {
        int dp[][][] = new int[n][3][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 4; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(0, 0, 0, n, dp);
    }

    int solve(int idx, int abs, int late, int n, int[][][] dp){
        if(late >= 3 || abs >= 2){
            return 0;
        }
        if(idx == n){
            if(abs < 2 && late <= 2){
                return 1;
            }
            return 0;
        }
        if(dp[idx][abs][late] != -1){
            return dp[idx][abs][late];
        }
        int P = solve(idx + 1, abs, 0, n, dp) % MOD;
        int A = solve(idx + 1, abs + 1, 0, n, dp) % MOD;
        int L = solve(idx + 1, abs, late + 1, n, dp) % MOD;
        return dp[idx][abs][late] = (((P + A) % MOD) + L) % MOD;
    }
}