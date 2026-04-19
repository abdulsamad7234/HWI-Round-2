/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<TreeNode, Map<Boolean, Integer>> map;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        int ans1 = solve(root, false);
        int ans2 = solve(root, true);
        return Math.max(ans1, ans2);
    }

    public int solve(TreeNode root, boolean check){
        if(root == null){
            return 0;
        }
        if(map.containsKey(root) && map.get(root).containsKey(check)){
            return map.get(root).get(check);
        }
        int notTake = solve(root.right, false) + solve(root.left, false);
        int take = 0;
        if(check == false){
            take += root.val + solve(root.right, true) + solve(root.left, true);
        }
        int ans = Math.max(take, notTake);
        map.putIfAbsent(root, new HashMap<>());
        map.get(root).put(check, ans);
        return ans;
    }
}