class Solution {
    static Integer[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for(int i = 0; i < n; i++){
            arr[i + 1] = nums[i];
        }
        dp = new Integer[n + 1][n + 1];
        return solve(1, n, arr);
    }

    public int solve(int i, int j, int[] arr){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int max = (int) -1e9;
        for(int k = i; k <= j; k++){
            int cost = (arr[i - 1] * arr[k] * arr[j + 1]) + solve(i, k - 1, arr) + solve(k + 1, j, arr);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }
}