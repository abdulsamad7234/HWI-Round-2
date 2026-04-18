class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int n = s.length();
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                stb.append(s.charAt(i));
            }
        }
        
        s = stb.toString();

        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}