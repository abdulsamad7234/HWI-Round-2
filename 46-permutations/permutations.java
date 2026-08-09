class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean vis[] = new boolean[nums.length];
        solve(new ArrayList<>(), ans, vis, nums);
        return ans;
    }

    void solve(List<Integer> list, List<List<Integer>> ans, boolean[] vis, int[] nums){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j = 0; j < nums.length; j++){
            if(vis[j] != true){
                vis[j] = true;
                list.add(nums[j]);
                solve(list, ans, vis, nums);
                vis[j] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}