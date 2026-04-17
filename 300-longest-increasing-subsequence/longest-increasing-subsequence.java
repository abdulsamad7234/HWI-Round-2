class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int idx = findLower(nums[i], list);
            if(idx == list.size()){
                list.add(nums[i]);
            }else{
                list.set(idx, nums[i]);
            }
        }
        return list.size();
    }

    public int findLower(int target, List<Integer> list){
        int ans = list.size();
        int low = 0;
        int high = list.size() - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(list.get(mid) >= target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}