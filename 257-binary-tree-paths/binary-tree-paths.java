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
    List<String>list=new ArrayList<>();
    void buildPath(TreeNode root, String res){
        if(root==null)
            return;
        if(!res.isEmpty())
            res+="->";
        res+=root.val;
        if(root.left==null && root.right==null)
            list.add(res);
        buildPath(root.left,res);
        buildPath(root.right,res);
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        buildPath(root,"");
        return list;
    }
}