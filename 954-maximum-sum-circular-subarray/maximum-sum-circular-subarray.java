class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = nums[0];
        int max = nums[0];
        int currMin = nums[0];
        int min = nums[0];
        int totalSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            currMax = Math.max(nums[i], nums[i] + currMax);
            max = Math.max(max, currMax);
            currMin = Math.min(nums[i], nums[i] + currMin);
            min = Math.min(min, currMin);
            totalSum += nums[i];
        }

        int circularMax = totalSum - min;
        if(max < 0){
            return max;
        }
        return Math.max(max, totalSum - min);
    }
}