class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            int curr = num.charAt(i) - '0';
            while(!st.isEmpty() && k > 0 && st.peek() > curr){
                st.pop();
                k--;
            }
            st.push(curr);
        }
        while(k > 0){
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();
        int idx = 0;
        while(idx < ans.length() && ans.charAt(idx) == '0'){
            idx++;
        }
        String finalAns = ans.substring(idx);
        return finalAns.equals("") ? "0" : finalAns;
    }
}