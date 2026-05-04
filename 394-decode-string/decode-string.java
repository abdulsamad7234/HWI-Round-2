class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ']'){
                StringBuilder stb1 = new StringBuilder();
                while(!st.isEmpty() && (st.peek() >= 'a' && st.peek() <= 'z')){
                    stb1.append(st.pop());
                }
                String newStr = stb1.reverse().toString();
                st.pop();

                StringBuilder  stb2= new StringBuilder();
                while(!st.isEmpty() && (st.peek() >= '0' && st.peek() <= '9')){
                    stb2.append(st.pop());
                }
                int k = Integer.parseInt(stb2.reverse().toString());
                
                StringBuilder ans = new StringBuilder();
                if(!stb1.toString().equals("")){
                    while(k > 0){
                        ans.append(newStr);
                        k--;
                    }
                }

                for(int idx = 0; idx < ans.length(); idx++){
                    st.push(ans.charAt(idx));
                }
            }else{
                st.push(ch);
            }
        }

        StringBuilder finalAns = new StringBuilder();
        while(!st.isEmpty()){
            finalAns.append(st.pop());
        }
        if(finalAns.length() > 0){
            return finalAns.reverse().toString();
        }
        return "";
    }
}