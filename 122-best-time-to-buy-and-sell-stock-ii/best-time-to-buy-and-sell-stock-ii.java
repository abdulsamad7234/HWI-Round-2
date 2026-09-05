class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];

        for(int idx = n - 1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 0){
                    int notTake = dp[idx + 1][buy];
                    int take = -prices[idx] + dp[idx + 1][1];
                    dp[idx][buy] = Math.max(notTake, take);
                }else{
                    int notTake = dp[idx + 1][buy];
                    int take = prices[idx] + dp[idx + 1][0];
                    dp[idx][buy] = Math.max(notTake, take);
                }
            }
        }
        return dp[0][0];
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