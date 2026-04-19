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
    int totalCount = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        findSum(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return (int)totalCount;
    }

    public void findSum(TreeNode root, int target, long sum){
        if(root == null){
            return;
        }
        sum += root.val;
        if(sum == target){
            totalCount++;
        }
        findSum(root.left, target, sum);
        findSum(root.right, target, sum);
    }
}