class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int idx = 2; idx <= n; idx++){
            int one_step = dp[idx - 1];
            int two_step = dp[idx - 2];
            dp[idx] = one_step + two_step;
        }
        return dp[n];
    }

    int solve(int idx, int[] dp){
        if(idx == 0 || idx == 1){
            return 1;
        }
        if(idx < 0) return 0;
        if(dp[idx] != -1){
            return dp[idx];
        }
        int one_step = solve(idx - 1, dp);
        int two_step = solve(idx - 2, dp);
        return dp[idx] = one_step + two_step;
    }
}