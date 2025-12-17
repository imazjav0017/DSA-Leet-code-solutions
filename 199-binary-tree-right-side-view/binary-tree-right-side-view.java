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
        Queue<TreeNode>bfs=new LinkedList<>();
        List<Integer>res=new ArrayList<>();
        if(root==null)
            return res;
        bfs.offer(root);
        while(!bfs.isEmpty()){
            int n=bfs.size();
            for(int i=0;i<n-1;i++){
                TreeNode x= bfs.poll();
                if(x.left!=null)bfs.offer(x.left);
                if(x.right!=null)bfs.offer(x.right);
            }
            TreeNode right=bfs.poll();
            res.add(right.val);
            if(right.left!=null)bfs.offer(right.left);
            if(right.right!=null)bfs.offer(right.right);
        }
        return res;
    }
}