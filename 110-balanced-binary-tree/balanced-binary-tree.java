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
    int[] heights(TreeNode root){
        if(root==null){
            return new int[]{1,0,0};
        }
        int[]lhs=heights(root.left);
        int lh=1+Math.max(lhs[1],lhs[2]);
        int[]rhs=heights(root.right);
        int rh=1+Math.max(rhs[1],rhs[2]);
        boolean isBalanced= (Math.abs(lh-rh)<=1) && (lhs[0]==1 && rhs[0]==1);
        return new int[]{isBalanced?1:0,lh,rh};
    }
    public boolean isBalanced(TreeNode root) {
        int[]res=heights(root);
        return res[0]==1;
    }
}