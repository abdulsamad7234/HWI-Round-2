class Solution {
    static Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length][nums.length + 1];
        return solve(nums.length - 1, -1, nums);
    }

    public int solve(int idx, int prev, int[] nums){
        if(idx < 0){
            return 0;
        }
        if(dp[idx][prev + 1] != null){
            return dp[idx][prev + 1];
        }
        int notTake = solve(idx - 1, prev, nums);
        int take = 0;
        if(prev == -1 || nums[idx] < nums[prev]){
            take = 1 + solve(idx - 1, idx, nums);
        }
        return dp[idx][prev + 1] = Math.max(notTake, take);
    }
}