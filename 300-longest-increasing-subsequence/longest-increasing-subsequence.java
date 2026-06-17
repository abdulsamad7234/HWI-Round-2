class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int idx = upperBound(nums[i], ans);
            if(idx == ans.size()){
                ans.add(nums[i]);
            }else{
                ans.set(idx, nums[i]);
            }
        }
        return ans.size();
    }

    int upperBound(int num, ArrayList<Integer> list){
        int ans = -1;
        int l = 0;
        int r = list.size() - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(list.get(mid) >= num){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return (ans == -1) ? list.size() : ans;
    }
}