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
    boolean dfs(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null)
            return true;
        if(root1==null ||root2==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        TreeNode left1=root1.left,left2=root2.left;
        TreeNode right1=root1.right,right2=root2.right;
        boolean flip =
    ((left1 == null && right2 == null) ||
     (left1 != null && right2 != null && left1.val == right2.val))
    &&
    ((right1 == null && left2 == null) ||
     (right1 != null && left2 != null && right1.val == left2.val));

boolean noFlip =
    ((left1 == null && left2 == null) ||
     (left1 != null && left2 != null && left1.val == left2.val))
    &&
    ((right1 == null && right2 == null) ||
     (right1 != null && right2 != null && right1.val == right2.val));
        if(!flip && !noFlip)
            return false;
        if(flip){
            return dfs(left1,right2) &&
            dfs(right1,left2);
        }
        else{
            return dfs(left1,left2) &&
            dfs(right1,right2);
        }
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1,root2);
    }
}