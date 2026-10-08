class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder stb = new StringBuilder();
        int open = 0;
        int close = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
                if(open != 1){
                    stb.append(ch);
                }
            }else{
                close++;
                if(close == open){
                    open = 0;
                    close = 0;
                }else{
                    stb.append(ch);
                }
            }
        }
        return stb.toString();
    }
}