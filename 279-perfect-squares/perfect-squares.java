class Solution {
    static Integer dp[];
    public int numSquares(int n) {
        dp = new Integer[n + 1];
        return solve(n);
    }

    public int solve(int n){
        if(n == 0){
            return 0;
        }
        if(dp[n] != null){
            return dp[n];
        }
        int minCount = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++){
            int count = 1 + solve(n - (i * i));
            minCount = Math.min(minCount, count);
        }
        return dp[n] = minCount;
    }
}