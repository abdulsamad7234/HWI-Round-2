class Solution {
    static Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int i = 0; i < nums.length; i++){
            target += nums[i];
        }
        if((target & 1) == 1){
            return false;
        }
        target /= 2;
        dp = new Boolean[nums.length][target + 1];
        return solve(nums.length - 1, target, nums);
    }

    public boolean solve(int idx, int target, int[] nums){
        if(idx == 0){
            if(target == nums[0]){
                return true;
            }else{
                return false;
            }
        }
        if(target == 0){
            return true;
        }
        if(dp[idx][target] != null){
            return dp[idx][target];
        }
        boolean notTake = solve(idx - 1, target, nums);
        boolean take = false;
        if(target >= nums[idx]){
            take = solve(idx - 1, target - nums[idx], nums);
        }
        return dp[idx][target] = take || notTake;
    }
}