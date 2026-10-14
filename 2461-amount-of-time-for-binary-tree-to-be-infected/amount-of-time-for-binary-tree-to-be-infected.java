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
    TreeNode startNode=null;
    void buildGraph(TreeNode root,Map<TreeNode,TreeNode>map,int start){
        if(root.val==start)
            startNode=root;
        if(root.left!=null){
            map.put(root.left,root);
            buildGraph(root.left,map,start);
        }
        if(root.right!=null){
            map.put(root.right,root);
            buildGraph(root.right,map,start);
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode>map=new HashMap<>();
        buildGraph(root,map,start);
        Queue<TreeNode>q=new ArrayDeque<>();
        q.offer(startNode);
        int min=-1;
        Set<Integer>visited=new HashSet<>();
        visited.add(startNode.val);
        while(!q.isEmpty()){
            int s=q.size();
            min++;
            for(int i=0;i<s;i++){
                TreeNode node=q.poll();
                if(node.left!=null && !visited.contains(node.left.val)){
                    q.offer(node.left);
                    visited.add(node.left.val);
                }
                if(node.right!=null && !visited.contains(node.right.val)){
                    q.offer(node.right);
                    visited.add(node.right.val);
                }
                if(map.getOrDefault(node,null)!=null && !visited.contains(map.get(node).val)){
                    q.offer(map.get(node));
                    visited.add(map.get(node).val);
                }
            }
        }
        return min;
    }
}