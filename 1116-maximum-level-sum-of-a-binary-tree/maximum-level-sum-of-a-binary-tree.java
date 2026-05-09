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
    public int maxLevelSum(TreeNode root) {
        int maxSum=root.val;
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        int maxLevel=1;
        int level=1;
        while(!q.isEmpty()){
            int n=q.size();
            int sum=0;
            for(int i=0;i<n;i++){
                TreeNode x=q.poll();
                if(x.left!=null)
                    q.offer(x.left);
                if(x.right!=null)
                    q.offer(x.right);
                sum+=x.val;
            }
            if(sum>maxSum){
                maxSum=sum;
                maxLevel=level;
            }
            level++;
        }
        return maxLevel;
    }
}