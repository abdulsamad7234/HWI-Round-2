class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }
        int l = 0;
        int r = 0;
        int jumps = 0;
        while(r < n - 1){
            int maxReach = 0;
            for(int i = l; i <= r; i++){
                maxReach = Math.max(maxReach, i + nums[i]);
            }
            l = r + 1;
            r = maxReach;
            jumps++;
        }
        return jumps;
    }
}