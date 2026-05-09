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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        if(root==null)
            return res;
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode x=q.poll();
                if(x.left!=null)
                    q.offer(x.left);
                if(x.right!=null)
                    q.offer(x.right);
                if(i==n-1){
                    res.add(x.val);
                }
            }
        }
        return res;

    }
}