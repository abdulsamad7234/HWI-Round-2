class Solution {
    static int[] dp;
    public int jump(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, nums);
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
        for(int i = 1; i <= nums[idx]; i++){
            minCost = Math.min(minCost, 1 + solve(idx + i, nums));
        }
        return dp[idx] =  minCost;
    }
}