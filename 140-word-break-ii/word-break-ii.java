class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();

        solve(0, s, dict, "", ans);

        return ans;
    }

    public void solve(int start, String s, Set<String> dict, String path, List<String> ans){

        if(start == s.length()){
            ans.add(path.trim());
            return;
        }

        for(int right = start + 1; right <= s.length(); right++){

            String sub = s.substring(start, right);

            if(dict.contains(sub)){
                solve(right, s, dict, path + sub + " ", ans);
            }
        }
    }
}