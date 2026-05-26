class Solution {
    public int maxProduct(int[] nums) {
        int preProduct = 1;
        int postProduct = 1;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            preProduct *= nums[i];
            postProduct *= nums[n - i - 1];
            max = Math.max(max, Math.max(preProduct, postProduct));
            if(preProduct == 0){
                preProduct = 1;
            }
            if(postProduct == 0){
                postProduct = 1;
            }
        }
        return max;
    }
}