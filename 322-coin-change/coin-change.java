class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = solve(coins.length - 1, amount, coins, dp);
        if(ans >= (int) 1e9){
            return -1;
        }
        return ans;
    }

    int solve(int idx, int target, int[] coins, int[][] dp){
        if(idx < 0){
            return (int) 1e9;
        }
        if(target == 0){
            return 0;
        }
        if(dp[idx][target] != -1){
            return dp[idx][target];
        }
        if(coins[idx] <= target){
            int take = 1 + solve(idx, target - coins[idx], coins, dp);
            int notTake = solve(idx - 1, target, coins, dp);
            return dp[idx][target] = Math.min(take, notTake);
        }
        int notTake = solve(idx - 1, target, coins, dp);
        return dp[idx][target] = notTake;
    }
}