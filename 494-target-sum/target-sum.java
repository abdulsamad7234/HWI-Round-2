class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int x : nums){
            totalSum += x;
        }
        int[][] dp = new int[nums.length][2 * totalSum + 1];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, target, nums, dp, totalSum);
    }

    int solve(int idx, int sum, int target, int[] nums, int[][] dp, int offset){
        if(idx == nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        if(dp[idx][sum + offset] != -1){
            return dp[idx][sum + offset];
        }
        int add = solve(idx + 1, sum + nums[idx], target, nums, dp, offset);
        int sub = solve(idx + 1, sum - nums[idx], target, nums, dp, offset);
        return dp[idx][sum + offset] = add + sub;
    }
}