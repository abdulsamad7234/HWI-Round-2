class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        return find(1, n, "1");
    }

    String find(int count, int n, String s){
        if(count == n){
            return s;
        }
        String res = findRLE(s);
        return find(count + 1, n, res);
    }

    public String findRLE(String s){
        StringBuilder stb = new StringBuilder();
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) == s.charAt(i)){
                count++;
            }else{
                stb.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        stb.append(count).append(s.charAt(s.length() - 1));
        return stb.toString();
    }
}