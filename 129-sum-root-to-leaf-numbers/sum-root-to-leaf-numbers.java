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
    int sum=0;
    void fill(TreeNode root,String s){
        if(root==null)
            return;
        s+=root.val;
        if(root.left==null && root.right==null){
            //System.out.println(s);
            int num=Integer.parseInt(s);
            sum+=num;
        }
        fill(root.left,s);
        fill(root.right,s);
    }
    public int sumNumbers(TreeNode root) {
        fill(root,"");
        return sum;
    }
}