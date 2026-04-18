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
    static int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        return solve(root, 0);
    }

    public static boolean solve(TreeNode root, int target){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            if(target + root.val == targetSum){
                return true;
            }
            return false;
        }
        boolean left = solve(root.left, target + root.val);
        boolean right = solve(root.right, target + root.val);
        return left || right;
    }
}