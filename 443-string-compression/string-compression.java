class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }
        StringBuilder stb = new StringBuilder();
        int count = 1;
        for(int i = 1; i < chars.length; i++){
            if(chars[i - 1] == chars[i]){
                count++;
            }else{
                if(count == 1){
                    stb.append(chars[i - 1]);
                }else{
                    stb.append(chars[i - 1]).append(count);
                    count = 1;
                }
            }
        }
        stb.append(chars[chars.length - 1]);
        if(count > 1) stb.append(count);
        int i = 0;
        while(i < chars.length && i < stb.length()){
            chars[i] = stb.charAt(i);
            i++;
        }
        return stb.length();
    }
}