class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    void solve(int idx, int[] nums, List<Integer> list, List<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        //not Take
        solve(idx + 1, nums, list, ans);
        //Take
        list.add(nums[idx]);
        solve(idx + 1, nums, list, ans);
        list.remove(list.size() - 1);
    }
}