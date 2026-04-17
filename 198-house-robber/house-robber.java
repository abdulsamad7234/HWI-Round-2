class Solution {
    static Integer dp[];
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        int ans = solve(nums.length - 1, nums);
        return (ans <= (int) -1e9) ? 0 : ans;
    }

    public int solve(int idx, int[] nums){
        if(idx == 0){
            return nums[0];
        }
        if(idx < 0){
            return 0;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        int notTake = solve(idx - 1, nums);
        int take = nums[idx] + solve(idx - 2, nums);
        return dp[idx] = Math.max(notTake, take);
    }
}