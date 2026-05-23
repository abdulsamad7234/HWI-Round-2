class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while(left < right){
            while(left < n &&  nums[left] != 0){
                left++;
            }
            while(right >= 0 && nums[right] == 0){
                right--;
            }
            if(left < right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                count++;
            }
            left++;
            right--;
        }
        return count;
    }
}