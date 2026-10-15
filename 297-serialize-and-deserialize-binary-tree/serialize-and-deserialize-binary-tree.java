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
    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb=new StringBuilder();
        serializeHelper(root,sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    void serializeHelper(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]tokens=data.split(",");
        int[]idx=new int[1];
        return helper(tokens,idx);
    }
    TreeNode helper(String[]tokens,int[] idx){
        String token=tokens[idx[0]++];
        if(token.equals("#")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(token));
        node.left=helper(tokens,idx);
        node.right=helper(tokens,idx);
        return node;
    }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));