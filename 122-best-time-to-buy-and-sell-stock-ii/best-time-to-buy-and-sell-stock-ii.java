class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, prices, dp);
    }

    int solve(int idx, int buy, int[] prices, int[][] dp){
        if(idx == prices.length){
            return 0;
        }
        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }
        if(buy == 0){
            int notTake = solve(idx + 1, buy, prices, dp);
            int take = -prices[idx] + solve(idx + 1, 1, prices, dp);
            return dp[idx][buy] = Math.max(notTake, take);
        }else{
            int notTake = solve(idx + 1, buy, prices, dp);
            int take = prices[idx] + solve(idx + 1, 0, prices, dp);
            return dp[idx][buy] = Math.max(notTake, take);
        }
    }
}