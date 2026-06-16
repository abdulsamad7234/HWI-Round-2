class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        int prev2 = 1;
        int prev1 = 1;
        for(int idx = 2; idx <= n; idx++){
            int curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
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