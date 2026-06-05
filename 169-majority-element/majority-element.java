class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int vote  = 1;
        int candidate = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate){
                vote++;
            }else{
                vote--;
            }
            if(vote == 0){
                candidate = nums[i];
                vote = 1;
            }
        }

        return candidate;
    }
}