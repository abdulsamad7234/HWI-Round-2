class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        solve(0, 0, new StringBuilder(), s, ans);
        int max = Integer.MIN_VALUE;
        for(String str : ans){
            max = Math.max(max, str.length());
        }
        List<String> finalAns = new ArrayList<>();
        for(String str : ans){
            if(str.length() == max){
                finalAns.add(str);
            }
        }
        return finalAns;
    }

    void solve(int idx, int open, StringBuilder curr, String s, Set<String> ans){
        if(idx == s.length()){
            if(open == 0){
                ans.add(curr.toString());
            }
            return;
        }

        if(open < 0){
            return;
        }

        char ch = s.charAt(idx);
        if(ch == '('){
            solve(idx + 1, open, curr, s, ans);
            curr.append(ch);
            solve(idx + 1, open + 1, curr, s, ans);
            curr.deleteCharAt(curr.length() - 1);
        }else if(ch == ')'){
            solve(idx + 1, open, curr, s, ans);
            curr.append(ch);
            solve(idx + 1, open - 1, curr, s, ans);
            curr.deleteCharAt(curr.length() - 1);
        }else{
            curr.append(ch);
            solve(idx + 1, open, curr, s, ans);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}