class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int[] need = new int[128];
        int required = 0;
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            need[ch]++;
            required++;
        }
        
        int left = 0;
        int maxL = Integer.MAX_VALUE;
        int start = 0;
        for(int right  = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(need[ch] > 0){
                required--;
            }
            need[ch]--;
            while(required == 0){
                if(right - left + 1 < maxL){
                    maxL = right - left + 1;
                    start = left;
                }
                
                ch = s.charAt(left);
                need[ch]++;
                if(need[ch] > 0) required++;
                left++;
            }
        }

        return maxL == Integer.MAX_VALUE ? "" : s.substring(start, start + maxL);
    }
}