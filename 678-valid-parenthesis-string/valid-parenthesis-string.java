class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length() + 1];
        return solve(0, 0, s, dp);
    }

    boolean solve(int idx, int open, String s, Boolean[][] dp){
        if(idx == s.length()){
            return open == 0;
        }
        if(open < 0) return false;
        
        if(dp[idx][open] != null) return dp[idx][open];

        char ch = s.charAt(idx);
        if(ch == '('){
            return dp[idx][open] = solve(idx + 1, open + 1, s, dp);
        }else if(ch == ')'){
            return dp[idx][open] = solve(idx + 1, open - 1, s, dp);
        }else{
            return dp[idx][open] = solve(idx + 1, open + 1, s, dp) || solve(idx + 1, open - 1, s, dp) || solve(idx + 1, open, s, dp);
        }
    }
}