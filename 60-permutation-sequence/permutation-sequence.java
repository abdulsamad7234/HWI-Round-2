class Solution {
    public String getPermutation(int n, int k) {
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        for(int i = 1; i < k; i++){
            nextPermutation(arr);
        }

        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < n; i++){
            stb.append(arr[i]);
        }
        return stb.toString();
    }

    public int[] nextPermutation(int[] nums) {
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
        return nums;
    }

    void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int i, int j, int[] nums){
        while(i < j){
            swap(i, j, nums);
            i++;
            j--;
        }
    }

    
}