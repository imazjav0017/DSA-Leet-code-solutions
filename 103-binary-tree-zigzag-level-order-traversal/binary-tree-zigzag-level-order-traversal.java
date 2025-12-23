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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        List<TreeNode>queue=new ArrayList<>();
        if(root==null)
            return res;
        queue.add(root);
        boolean isEven=true;
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer>list=new ArrayList<>();
            if(!isEven){
                for(int i=n-1;i>=0;i--){
                    list.add(queue.get(i).val);
                }
            }
            for(int i=0;i<n;i++){
                    TreeNode x=queue.get(0);
                    if(isEven)list.add(x.val);
                    if(x.left!=null)queue.add(x.left);
                    if(x.right!=null)queue.add(x.right);
                    queue.remove(0);
                }
            isEven=!isEven;
            res.add(list);
            
        }
        return res;
    }
}