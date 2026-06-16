class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(nums.length - 1, -1, nums, dp);
    }

    int solve(int idx, int prev, int[] nums, int[][] dp){
        if(idx < 0){
            return 0;
        }
        if(dp[idx][prev + 1] != -1){
            return dp[idx][prev + 1];
        }
        if(prev == -1 || nums[idx] < nums[prev]){
            int take = 1 + solve(idx - 1, idx, nums, dp);
            int notTake = solve(idx - 1, prev, nums, dp);
            return dp[idx][prev + 1] = Math.max(take, notTake);
        }
        int notTake = solve(idx - 1, prev, nums, dp);
        return dp[idx][prev + 1] = notTake;
    }
}