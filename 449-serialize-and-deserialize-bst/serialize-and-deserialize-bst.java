/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stb = new StringBuilder();
        traverse(root, stb);
        return stb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] idx = {0};
        return helperDeserialize(idx, arr);
    }

    public TreeNode helperDeserialize(int[] idx, String[] arr){
        if(arr[idx[0]].equals("null")){
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx[0]++]));
        root.left = helperDeserialize(idx, arr);
        root.right = helperDeserialize(idx, arr);
        return root;
    }

    public void traverse(TreeNode root, StringBuilder stb){
        if(root == null){
            stb.append("null").append(",");
            return;
        }
        stb.append(root.val).append(",");
        traverse(root.left, stb);
        traverse(root.right, stb);
    }

    public void buildTree(TreeNode root, int idx, String s){
        if(idx >= s.length()){
            return;
        }
        TreeNode leftNode = new TreeNode(s.charAt(idx) - '0');
        TreeNode rightNode = new TreeNode(s.charAt(idx + 1) - '0');
        root.left = leftNode;
        root.right = rightNode;
        buildTree(root.left, idx + 2, s);
        buildTree(root.right, idx + 3, s);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;