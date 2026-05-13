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
class Least{
    int depth;
    TreeNode node;
    Least(int depth,TreeNode node){
        this.depth=depth;
        this.node=node;
    }
}
class Solution {
    Least lca(TreeNode root){
        if(root==null){
            return new Least(-1,null);
        }
        Least left=lca(root.left);
        Least right=lca(root.right);
        int ld=left.depth,rd=right.depth;
        TreeNode ans=null;
        int maxD=-1;
        if(ld>rd){
            ans=left.node;
            maxD=ld;
        }
        else if(rd>ld){
            ans=right.node;
            maxD=rd;
        }
        else{
            ans=root;
            maxD=ld;
        }
        return new Least(1+maxD,ans);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return (lca(root)).node;
    }
}