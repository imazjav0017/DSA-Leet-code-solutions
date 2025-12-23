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
    List<List<Integer>> res=new ArrayList<>();
    public void sum(TreeNode root,int currentSum, List<Integer>list,int targetSum){
        if(root==null){
            return;
        }
        currentSum+=root.val;
        list.add(root.val);
        if(currentSum == targetSum && root.left==null && root.right==null){
            res.add(new ArrayList<>(list));
        }
        else {
            sum(root.left,currentSum,list,targetSum);
            sum(root.right,currentSum,list,targetSum);
        }
        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         sum(root,0,new ArrayList<Integer>(),targetSum);
         return res;
    }
}