class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] arr = new int[len + 2];
        int ptr = 0;
        arr[ptr++] = 0;
        for(int i = 0; i < len; i++){
            arr[ptr++] = cuts[i];
        }
        arr[ptr++] = n;
        Arrays.sort(arr);
        int dp[][] = new int[len + 1][len + 1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(1, len, arr, dp);
    }

    int solve(int i, int j, int[] arr, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int minCost = Integer.MAX_VALUE;
        for(int idx = i; idx <= j; idx++){
            int cost = arr[j + 1] - arr[i - 1] + solve(i, idx - 1, arr, dp) + solve(idx + 1, j, arr, dp);
            minCost = Math.min(minCost, cost);
        }
        return dp[i][j] = minCost;
    }
}