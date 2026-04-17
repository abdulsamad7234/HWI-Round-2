class Solution {
    static boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int i = 0; i < nums.length; i++){
            target += nums[i];
        }
        if((target & 1) == 1){
            return false;
        }
        target /= 2;
        dp = new boolean[nums.length][target + 1];
        for(int j = 0; j < target + 1; j++){
            if(j == nums[0]){
                dp[0][j] = true;
            }else{
                dp[0][j] = false;
            }
        }

        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < nums.length; i++){
            for(int j = 1; j < target + 1; j++){
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if(j >= nums[i]){
                    take = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[nums.length - 1][target];
    }

    // public boolean solve(int idx, int target, int[] nums){
    //     if(idx == 0){
    //         if(target == nums[0]){
    //             return true;
    //         }else{
    //             return false;
    //         }
    //     }
    //     if(target == 0){
    //         return true;
    //     }
    //     if(dp[idx][target] != null){
    //         return dp[idx][target];
    //     }
    //     boolean notTake = solve(idx - 1, target, nums);
    //     boolean take = false;
    //     if(target >= nums[idx]){
    //         take = solve(idx - 1, target - nums[idx], nums);
    //     }
    //     return dp[idx][target] = take || notTake;
    // }
}