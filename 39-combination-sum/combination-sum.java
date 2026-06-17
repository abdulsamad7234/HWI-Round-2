class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    void solve(int idx, int[] candidates, int target, List<Integer> list, List<List<Integer>> ans){
        if(target < 0 || idx == candidates.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        //notTake
        solve(idx + 1, candidates, target, list, ans);
        //take
        list.add(candidates[idx]);
        solve(idx, candidates, target - candidates[idx], list, ans);
        list.remove(list.size() - 1);
    }
}