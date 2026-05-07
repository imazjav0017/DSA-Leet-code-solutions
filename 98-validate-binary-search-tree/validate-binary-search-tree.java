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
    boolean isValid=true;
    Integer prev=null;
    void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        if(prev!=null && prev>=root.val){
            isValid=false;
            return;
        }
        if(!isValid)return;
        prev=root.val;
        inorder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return isValid;
    }
}