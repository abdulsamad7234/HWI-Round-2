class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int maxReach = 0;
        int jumps = 0;

        while(right < n - 1){
            jumps++;
            for(int i = left; i <= right; i++){
                maxReach = Math.max(maxReach, nums[i] + i);
            }
            left = right + 1;
            right = maxReach;
        }
        return jumps;
    }
}