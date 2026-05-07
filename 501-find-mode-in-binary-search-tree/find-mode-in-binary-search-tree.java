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
    List<Integer>res=new ArrayList<>();
    Integer prev=null;
    int count=0,maxCount=0;
    void helper(TreeNode root){
        if(root==null)
            return;
        helper(root.left);
        if(prev!=null && prev==root.val){
            count++;
        }
        else{
            count=1;
        }
        if(count>maxCount){
            maxCount=count;
            res.clear();
            res.add(root.val);
        }else if(count==maxCount){
            res.add(root.val);
        }
        prev=root.val;
        helper(root.right);
    }
    public int[] findMode(TreeNode root) {
        helper(root);
        int[]ans=new int[res.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}