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
    String serialize(TreeNode root,StringBuilder builder){
        if(root==null)
            {
                builder.append("#,");
                return builder.toString();
            }
        builder.append("@"+root.val+",");
        serialize(root.left,builder);
        serialize(root.right,builder);
        return builder.toString();
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder b1=new StringBuilder();
        StringBuilder b2=new StringBuilder();
        String subString=serialize(subRoot,b1);
        String str=serialize(root,b2);
        return str.contains(subString);
    }
}