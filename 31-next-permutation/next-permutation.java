class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idxToSwap = -1;
        for(int i = n - 1; i > 0; i--){
            if(nums[i - 1] < nums[i]){
                idxToSwap = i - 1;
                break;
            }
        }

        
        if(idxToSwap != -1){
            for(int i = n - 1; i >= idxToSwap + 1; i--){
                if(nums[i] > nums[idxToSwap]){
                    swap(i, idxToSwap, nums);
                    break;
                }
            }
        }

        reverse(idxToSwap + 1, n - 1, nums);
        
    }

    void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int start, int end, int nums[]){
        while(start < end){
            swap(start, end, nums);
            start++;
            end--;
        }
    }
}