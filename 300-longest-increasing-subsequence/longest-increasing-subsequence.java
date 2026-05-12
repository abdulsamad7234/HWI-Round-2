class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int parent[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int max = 1;
        int lastIdx = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}