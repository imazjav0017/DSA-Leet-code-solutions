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
    int sum(TreeNode root,int k){
        if(root.left==null &&root.right==null){
            return root.val;
        }
        if(root.left!=null){
            int ls=root.val+sum(root.left,k-root.val);
            if(ls==k)
                return k;
        }
        if(root.right!=null){
            int rs=root.val+sum(root.right,k-root.val);
            if(rs==k)
                return k;
        }
         return -10001;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        int s=sum(root,targetSum);
        // System.out.println(s);
        return s==targetSum;
    }
}