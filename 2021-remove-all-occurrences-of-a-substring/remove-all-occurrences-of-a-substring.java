class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder stb = new StringBuilder();
        int n = s.length();
        int len = part.length();
        for(int i = 0; i < n; i++){
            stb.append(s.charAt(i));
            if(stb.length() >= len){
                boolean check = true;
                for(int j = 0; j < len; j++){
                    if(stb.charAt(stb.length() - len + j) != part.charAt(j)){
                        check = false;
                        break;
                    }
                }

                if(check){
                    stb.delete(stb.length() - len, stb.length());
                }
            }
        }

        return stb.toString();
    }
}