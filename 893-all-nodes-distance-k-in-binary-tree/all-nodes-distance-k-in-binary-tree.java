/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void buildGraph(TreeNode root, Map<TreeNode,TreeNode>map){
        if(root.left!=null){
            map.put(root.left,root);
            buildGraph(root.left,map);
        }
        if(root.right!=null){
            map.put(root.right,root);
            buildGraph(root.right,map);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>map=new HashMap<>();
        buildGraph(root,map);
        Queue<TreeNode>q=new ArrayDeque<>();
        Set<Integer>visited=new HashSet<>();
        q.offer(target);
        visited.add(target.val);
        int dist=0;
        while(dist!=k){
            int s=q.size();
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
                TreeNode parent=map.getOrDefault(node,null);
                if(parent!=null && !visited.contains(parent.val)){
                    q.offer(parent);
                    visited.add(parent.val);
                }
            }
            dist++;
        }
        List<Integer>res=new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
}