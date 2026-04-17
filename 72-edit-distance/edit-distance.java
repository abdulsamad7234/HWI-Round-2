class Solution {
    static Integer[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length() + 1][word2.length() + 1];
        return solve(word1.length() - 1, word2.length() - 1, word1, word2);
    }

    public int solve(int i, int j, String word1, String word2){
        if(i == -1){
            return j + 1;
        }
        if(j == -1){
            return i + 1;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = solve(i - 1, j - 1, word1, word2);
        }
        int insert = 1 + solve(i, j - 1, word1, word2);
        int delete = 1 + solve(i - 1, j, word1, word2);
        int replace = 1 + solve(i - 1, j - 1, word1, word2);
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
}