class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxL = 0;
        String ans = "";
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j <= n; j++){
                String sub = s.substring(i, j);
                if(isPalindrome(sub) && (j - i) > maxL){
                    maxL = j - i;
                    ans = sub;
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}