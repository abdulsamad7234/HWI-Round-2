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
    static int count;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        traverse(root, targetSum);
        return count;
    }

    void traverse(TreeNode root, int targetSum){
        if(root == null) return;
        find(root, 0, targetSum);
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);

    }

    void find(TreeNode node, long sum, int targetSum){
        if(node == null){
            return;
        }
        sum += node.val;
        if(sum == targetSum) count++;
        find(node.left, sum, targetSum);
        find(node.right, sum, targetSum);
    }
}