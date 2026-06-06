class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i]){
                count++;
            }else{
                if(count > (n / 3)){
                    ans.add(nums[i - 1]);
                }
                count = 1;
            } 
        }
        if(count > (n / 3)){
            ans.add(nums[n - 1]);
        }
        return ans;
    }
}