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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(root, 0, targetSum, list, ans);
        return ans;
    }

    public void solve(TreeNode node, int sum, int targetSum, List<Integer> list, List<List<Integer>> ans){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            if(node.val + sum == targetSum){
                list.add(node.val);
                ans.add(new ArrayList(list));
                list.remove(list.size() - 1);
                return;
            }else{
                return;
            }
        }

        list.add(node.val);
        solve(node.left, sum + node.val, targetSum, list, ans);
        solve(node.right, sum + node.val, targetSum, list, ans);
        list.remove(list.size() - 1);
    }
}