class Solution {
    public String[] largestString(int[] nums) {
        int n = nums.length;
        String[] ans = new String[n];
        for(int i = 0; i < n; i++){
            int num = nums[i];
            char curr = 'a';
            StringBuilder stb = new StringBuilder();
            while(num > 1){
                if(num % 2 != 0){
                    stb.append(curr);
                }
                curr += 1;
                if(curr == 'z'){
                    for(int k = 0; k < num / 2; k++){
                        stb.append(curr);
                    }
                    break;
                }
                num /= 2;
            }
            if(num == 1){
                stb.append(curr);
            }
            ans[i] = stb.reverse().toString();
        }

        return ans;
    }
}