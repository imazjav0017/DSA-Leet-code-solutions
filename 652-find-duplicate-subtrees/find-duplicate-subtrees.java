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
    List<TreeNode>res=new ArrayList<>();
    Map<String,Integer>count=new HashMap<>();
    String serialize(TreeNode root){
        if(root==null){
            return "#,";
        }
        String left=serialize(root.left);
        String right=serialize(root.right);
        String ans="@"+root.val+left+right;
        count.put(ans,count.getOrDefault(ans,0)+1);
        if(count.get(ans)==2)
            res.add(root);
        return ans;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }
}