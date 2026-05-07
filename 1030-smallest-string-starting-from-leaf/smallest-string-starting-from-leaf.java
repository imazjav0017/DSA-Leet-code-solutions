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
    String minString="";
    String smallest(TreeNode root,String s){
        if(root==null)
            return "";
        char c=(char)('a'+root.val);
        s+=c;
        //System.out.println("root: "+c);
        if(root.left==null && root.right==null)
        {
            String rev=new StringBuilder(s).reverse().toString();
            //System.out.println(rev+" M: "+minString);
            if(minString.isEmpty()){
                minString=rev;
            }else{
                minString=rev.compareTo(minString)<0?rev:minString;
            }
        }
        else{
            smallest(root.left,s);
            smallest(root.right,s);
        }
        return minString;
    }
    public String smallestFromLeaf(TreeNode root) {
        return smallest(root,"");
    }
}