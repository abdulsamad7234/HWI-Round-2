class Solution {
    public String minWindow(String s, String t) {
        int[] arrS = new int[256];
        int[] arrT = new int[256];
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            arrT[ch]++;
        }

        int minL = Integer.MAX_VALUE;
        int startIdx = -1;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            arrS[ch]++;
            while(isContains(arrS, arrT)){
                if(isContains(arrS, arrT)){
                    if(minL > (right - left + 1)){
                        minL = right - left + 1;
                        startIdx = left;
                    }
                }
                arrS[s.charAt(left)]--;
                left++;
            }
        }
        return (minL == Integer.MAX_VALUE) ? "" : s.substring(startIdx, startIdx + minL);

    }

    boolean isContains(int[] arrS, int[] arrT){
        for(int i = 0; i < 256; i++){
            if(arrT[i] > arrS[i]){
                return false;
            }
        }
        return true;
    }
}