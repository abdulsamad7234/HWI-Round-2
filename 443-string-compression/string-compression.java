class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int left = 0;
        int right = 0;
        while(right < n){
            char ch = chars[right];
            int count = 0;
            while(right < n && chars[right] == ch){
                count++;
                right++;
            }
            chars[left++] = ch;
            if(count > 1){
                String temp = String.valueOf(count);
                for(char c : temp.toCharArray()){
                    chars[left++] = c;
                }
            }
        }
        return left;
    }
}