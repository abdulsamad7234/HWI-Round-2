class Solution {
    public int numDecodings(String s) {
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= 26; i++){
            set.add(String.valueOf(i));
        }
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0, s, set, dp);
    }

    int solve(int idx, String s, Set<String> set, int[] dp){
        if(idx >= s.length()){
            return 1;
        }
        if(dp[idx] != -1) return dp[idx];
        int ways = 0;
        for(int j = idx + 1; j <= Math.min(idx + 2, s.length()); j++){
            String sub = s.substring(idx, j);
            if(set.contains(sub)){
                ways += solve(j, s, set, dp);
            }
        }
        return dp[idx] = ways;
    }
}