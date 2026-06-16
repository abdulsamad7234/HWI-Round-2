class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    int solve(int idx, int[] dp){
        if(idx == 0){
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