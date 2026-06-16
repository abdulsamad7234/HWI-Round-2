class Solution {
    public int rob(int[] nums) {
        int[][] dp1 = new int[nums.length][2];
        int[][] dp2 = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp1[i], -1);
            Arrays.fill(dp2[i], -1);
        }
        return Math.max(solve(0, 0, nums, dp1), solve(0, 1, nums, dp2));
    }

    int solve(int idx, int check, int[] nums, int[][] dp){
        if(idx == nums.length){
            return 0;
        }
        if(dp[idx][check] != -1){
            return dp[idx][check];
        }
        if(check == 0){
            int take = nums[idx] + solve(idx + 1, 1, nums, dp);
            int notTake = solve(idx + 1, 0, nums, dp);
            return dp[idx][check] = Math.max(take, notTake);
        }
        return dp[idx][check] = solve(idx + 1, 0, nums, dp);
    }
}