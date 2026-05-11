class Solution {
    static Integer dp[][];
    public int numSquares(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(isPerfectSquare(i)){
                list.add(i);
            }
        }
        dp = new Integer[list.size()][n + 1];
        int ans = solve(list.size() - 1, n, list);
        return ans;
    }

    public int solve(int idx, int target, List<Integer> list){
        if(idx < 0){
            return (int) 1e9;
        }
        if(target == 0){
            return 0;
        }
        if(dp[idx][target] != null){
            return dp[idx][target];
        }
        int notTake = solve(idx - 1, target, list);
        int take = (int) 1e9;
        if(list.get(idx) <= target){
            take = 1 + solve(idx, target - list.get(idx), list);
        }
        return dp[idx][target] = Math.min(take, notTake);
    }

    public boolean isPerfectSquare(int num){
        int root = (int) Math.sqrt(num);
        return (root * root) == num;
    }
}