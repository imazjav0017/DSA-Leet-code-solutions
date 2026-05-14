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
    Map<TreeNode,TreeNode>parentMap=new HashMap<>();
    void dfs(TreeNode root){
        if(root==null) return;
        if(root.left!=null)
            parentMap.put(root.left,root);
        if(root.right!=null)
            parentMap.put(root.right,root);
        dfs(root.left);
        dfs(root.right);
    }
    TreeNode findNode(TreeNode root,int target){
        if(root==null)
            return null;
        if(root.val==target)
            return root;
        TreeNode left=findNode(root.left,target);
        if(left!=null) return left;
        return findNode(root.right,target);

    }
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode>q=new ArrayDeque<>();
        dfs(root);
        TreeNode startNode=findNode(root,start);
        q.offer(startNode);
        int min=-1;
        Set<Integer>visited=new HashSet<>();
        visited.add(startNode.val);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode x=q.poll();
                if(x.left!=null && !visited.contains(x.left.val)){
                    q.offer(x.left);
                    visited.add(x.left.val);
                }
                if(x.right!=null && !visited.contains(x.right.val)){
                    q.offer(x.right);
                    visited.add(x.right.val);
                }
                if(parentMap.containsKey(x) && !visited.contains(parentMap.get(x).val)){
                    q.offer(parentMap.get(x));
                    visited.add(parentMap.get(x).val);
                }
            }
            min++;
        }
        return min;

    }
}