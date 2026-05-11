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
    StringBuilder build=new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            build.append("#,");
            return build.toString();
        }
        build.append(root.val).append(",");
        serialize(root.left);
        serialize(root.right);
        return build.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]tokens=data.split(",");
        int[]index=new int[1];
        TreeNode root=deserializeHelper(tokens,index);
        return root;
    }
    private TreeNode deserializeHelper(String[]tokens,int[]index){
        if(index[0]>=tokens.length){
            return null;
        }
        String token=tokens[index[0]++];
        if(token.equals("#"))
            return null;
        TreeNode root=new TreeNode(Integer.parseInt(token));
        root.left=deserializeHelper(tokens,index);
        root.right=deserializeHelper(tokens,index);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));