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
    int max=0;
    int height(TreeNode root){
        if(root==null)
            return 0;
        int leftHeight=height(root.left);
        int rightHeight = height(root.right);
        int diameter=leftHeight+rightHeight;
        max=Math.max(diameter,max);
        return 1+Math.max(leftHeight,rightHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }
}