class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxL = 1;
        for(int i = 1; i < nums.length; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[prev] < nums[i] && dp[prev] + 1 > dp[i]){
                    dp[i] = dp[prev] + 1;
                    maxL = Math.max(maxL, dp[i]);
                }
            }
        }
        return maxL;
    }
}