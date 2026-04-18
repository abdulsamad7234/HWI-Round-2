class Solution {
    static int[] dp;
    public int jump(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        dp[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--){
            int minCost = (int)1e9;
            for(int k = nums[i]; k >= 1; k--){
                if(i + k < n){
                    minCost = Math.min(minCost, 1 + dp[i + k]);
                }
            }
            dp[i] = minCost;
        }
        return dp[0];
    }

    public int solve(int idx, int[] nums){
        if(idx == nums.length - 1){
            return 0;
        }
        if(idx >= nums.length){
            return (int)1e9;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int minCost = (int)1e9;
        for(int i = nums[idx]; i >= 1; i--){
            minCost = Math.min(minCost, 1 + solve(idx + i, nums));
        }
        return dp[idx] =  minCost;
    }
}