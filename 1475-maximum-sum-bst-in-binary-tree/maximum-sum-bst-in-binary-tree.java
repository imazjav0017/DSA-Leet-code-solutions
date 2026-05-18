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
    int maxSum=0;
    //int []- {1,1,1,1}-> isValid,min,max,sumSofar
    int[] dfs(TreeNode root){
        if(root==null){
            return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }
        int[]left=dfs(root.left);
        int[]right=dfs(root.right);
        boolean leftValid=left[0]==1,rightValid=right[0]==1;
        int[]ans=new int[4];
        if(leftValid && rightValid && left[2]<root.val && root.val<right[1]){
            ans[0]=1;
            ans[1]=Math.min(left[1],root.val);
            ans[2]=Math.max(right[2],root.val);
            ans[3]=left[3]+right[3]+root.val;
            maxSum=Math.max(maxSum,left[3]+right[3]+root.val);
        }
        else{
            ans[0]=0;
        }
        return ans;
    }
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }
}