class Solution {
    static Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return solve(s.length() - 1, p.length() - 1, s, p);
    }

    public boolean solve(int i, int j, String s, String p){
        if(i < 0 && j < 0){
            return true;
        }
        if(j < 0){
            return false;
        }
        if(i < 0){
            for(int k = j; k >= 0; k -= 2){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i) == p.charAt(j)){
            return dp[i][j] = solve(i - 1, j - 1, s, p);
        }else{
            if(p.charAt(j) == '.'){
                return dp[i][j] = solve(i - 1, j - 1, s, p);
            }else if(p.charAt(j) == '*'){
                boolean notTake = solve(i, j - 2, s, p);
                boolean take = false;
                if(p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.'){
                    take = solve(i - 1, j, s, p);
                }
                return dp[i][j] = take || notTake;
            }else{
                return dp[i][j] = false;
            }
        }
    }
}