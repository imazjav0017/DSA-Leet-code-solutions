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
    TreeNode buildTree(int[]preorder,int left, int right){
        if(left>right)
            return null;
        int rootVal=preorder[left];
        TreeNode root=new TreeNode(rootVal);
        int end=left+1;
        while(end<=right){
            if(preorder[end]>rootVal)
                break;
            end++;
        }
        root.left=buildTree(preorder,left+1,end-1);
        root.right=buildTree(preorder,end,right);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder,0,preorder.length-1);
    }
}