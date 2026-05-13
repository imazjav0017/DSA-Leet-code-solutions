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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int count=0;
        Queue<TreeNode>q=new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            count++;
            for(int i=0;i<n;i++){
                TreeNode x=q.poll();
                if(x.left==null && x.right==null)
                    return count;
                if(x.left!=null)
                    q.offer(x.left);
                if(x.right!=null)
                    q.offer(x.right);
            }
        }
        return count;

    }
}