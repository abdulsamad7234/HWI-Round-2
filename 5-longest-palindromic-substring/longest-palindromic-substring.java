class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxL = 0;
        String ans = "";
        for(int i = 0; i < n; i++){
            int left = i;
            int right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            int len = right - left + 1;
            if(len > maxL){
                maxL = len;
                ans = s.substring(left + 1, right);
            }

            if(i < n - 1){
                left = i;
                right = i + 1;
                while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                }
                len = right - left + 1;
                if(len > maxL){
                    maxL = len;
                    ans = s.substring(left + 1, right);
                } 
            }            
        }
        return ans;
    }
}