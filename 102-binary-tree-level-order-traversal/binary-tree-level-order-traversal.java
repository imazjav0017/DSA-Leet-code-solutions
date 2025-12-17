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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>bfs=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        bfs.offer(root);
        
        while(!bfs.isEmpty()){
            List<Integer>level=new ArrayList<Integer>();
            int n=bfs.size();
            for(int i=0;i<n;i++){
                TreeNode x= bfs.poll();
                level.add(x.val);
                if(x.left!=null)bfs.offer(x.left);
                if(x.right!=null)bfs.offer(x.right);
            }
            res.add(level);
        }
        return res;

    }
}