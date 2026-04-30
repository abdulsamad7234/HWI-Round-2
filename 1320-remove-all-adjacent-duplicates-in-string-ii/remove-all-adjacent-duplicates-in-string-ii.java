class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(!st.isEmpty() && st.peek().ch == curr){
                if(st.peek().freq + 1 == k){
                    st.pop();
                }else{
                    st.peek().freq++;
                }
            }else{
                st.push(new Pair(curr, 1));
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            Pair curr = st.pop();
            while(curr.freq > 0){
                ans.append(curr.ch);
                curr.freq--;
            }
        }
        return ans.reverse().toString();
    }

    class Pair{
        char ch;
        int freq;
        public Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
}