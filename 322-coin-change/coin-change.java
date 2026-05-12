class Solution {
    static Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length][amount + 1];
        int ans = solve(coins.length - 1, amount, coins);
        return (ans >= (int) 1e9) ? -1 : ans;
    }

    public int solve(int idx, int target, int[] coins){
        if(idx < 0){
            return (int) 1e9;
        }
        if(target == 0){
            return 0;
        }
        if(dp[idx][target] != null){
            return dp[idx][target];
        }
        int notTake = solve(idx - 1, target, coins);
        int take = (int) 1e9;
        if(target >= coins[idx]){
            take = 1 + solve(idx, target - coins[idx], coins);
        }
        return dp[idx][target] = Math.min(take, notTake);
    }
}