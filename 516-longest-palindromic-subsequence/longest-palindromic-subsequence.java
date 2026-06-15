class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder stb = new StringBuilder(s);
        String rev = stb.reverse().toString();
        int dp[][] = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, s, rev, dp);
    }

    public int solve(int i, int j, String s, String rev, int[][] dp){
        if(i == s.length() || j == rev.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == rev.charAt(j)){
            return 1 + solve(i + 1, j + 1, s, rev, dp);
        }
        int first = solve(i + 1, j, s, rev, dp);
        int second = solve(i, j + 1, s, rev, dp);
        return dp[i][j] = Math.max(first, second);
    }
}