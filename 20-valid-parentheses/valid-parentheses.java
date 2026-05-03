class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if((s.length() & 1) == 1) return false;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.isEmpty()) return false;
                char top = st.peek();
                if(ch == ')' && top == '('){
                    st.pop();
                }else if(ch == '}' && top == '{'){
                    st.pop();
                }else if(ch == ']' && top == '['){
                    st.pop();
                }else{
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}