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
    static int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        int ans = solve(root);
        return maxSum;
    }

    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = solve(root.left);
        if(left < 0) left = 0;
        int right = solve(root.right);
        if(right < 0) right = 0;
        int currVal = root.val;
        maxSum = Math.max(maxSum, currVal + left + right);
        return currVal + Math.max(left, right);
    }
}