class Solution {
    static int MOD = (int) 1e9 + 7;
    public int dieSimulator(int n, int[] rollMax) {
        int[][][] dp = new int[n][7][16];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 7; j++){
                for(int k = 0; k < 16; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(0, -1, 0, n, rollMax, dp);
    }

    int solve(int idx, int prev, int count, int n, int[] rollMax, int[][][] dp){
        if(idx == n) return 1;
        if(dp[idx][prev + 1][count] != -1){
            return dp[idx][prev + 1][count];
        }
        int ways = 0;
        for(int j = 0; j < 6; j++){
            if(prev == j){
                if(count + 1 <= rollMax[j]){
                    ways = (ways + solve(idx + 1, j, count + 1, n, rollMax, dp)) % MOD;
                }
            }else{
                ways = (ways + solve(idx + 1, j, 1, n, rollMax, dp)) % MOD;
            }
        }
        return dp[idx][prev + 1][count] = ways;
    }
}