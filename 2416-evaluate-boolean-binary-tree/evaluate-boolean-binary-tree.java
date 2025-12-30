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
    public boolean evaluateTree(TreeNode root) {
        if(root.left==null){
            boolean val=root.val==0?false:true;
            return val;
        }
        boolean left=evaluateTree(root.left);
        boolean right=evaluateTree(root.right);
        switch(root.val){
            case 2:
                return left || right;
            case 3:
                return left && right;
        }
        return left && right;
    }
}