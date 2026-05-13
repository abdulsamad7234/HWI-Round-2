class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int maxScore = nums[k];
        int i = k;
        int j = k;
        int min = nums[k];
        while(i > 0 || j < n){
            int leftValue = (i > 0) ? nums[i - 1] : 0;
            int rightValue = (j < n - 1) ? nums[j + 1] : 0;
            if(leftValue > rightValue){
                i--;
                min = Math.min(min, leftValue);
            }else{
                j++;
                min = Math.min(min, rightValue);
            }
            maxScore = Math.max(maxScore, min * (j - i + 1));
        }
        return maxScore;
    }
}