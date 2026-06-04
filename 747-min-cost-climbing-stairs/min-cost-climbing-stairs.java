class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp1 = new int[cost.length];
        int[] dp2 = new int[cost.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.min(solve(0, cost, dp1), solve(1, cost, dp2));
    }

    int solve(int idx, int[] cost, int[] dp){
        if(idx >= cost.length){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }
        int oneStep = cost[idx] + solve(idx + 1, cost, dp);
        int twoStep = cost[idx] + solve(idx + 2, cost, dp);
        return dp[idx] = Math.min(oneStep, twoStep);
    }
}