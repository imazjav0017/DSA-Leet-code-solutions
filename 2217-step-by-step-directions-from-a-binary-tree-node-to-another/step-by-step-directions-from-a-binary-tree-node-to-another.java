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
    TreeNode LCA(TreeNode root,int p, int q){
        if(root==null)
            return null;
        if(root.val==p||root.val==q)
            return root;
        TreeNode left=LCA(root.left,p,q);
        TreeNode right=LCA(root.right,p,q);
        if(left!=null && right!=null)
            return root;
        return left!=null?left:right;
    }
    boolean findPath(TreeNode root,StringBuilder sb, int target){
        if(root==null)
            return false;
        if(root.val==target)return true;
        sb.append('L');
        if(findPath(root.left,sb,target))
            return true;
        sb.deleteCharAt(sb.length()-1);
        sb.append('R');
        if(findPath(root.right,sb,target)){
            return true;
        }
        sb.deleteCharAt(sb.length()-1);
        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode l=LCA(root,startValue,destValue);
        StringBuilder startPath=new StringBuilder();
        StringBuilder endPath=new StringBuilder();
        findPath(l,startPath,startValue);
        findPath(l,endPath,destValue);
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<startPath.length();i++){
            ans.append('U');
        }
        ans.append(endPath);
        return ans.toString();

    }
}