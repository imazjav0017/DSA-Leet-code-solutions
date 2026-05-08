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
    void traverse(TreeNode root, Map<TreeNode,TreeNode>map){
        if(root==null)
            return;
        traverse(root.left,map);
        if(root.left!=null)
            map.put(root.left,root);
        if(root.right!=null)    
            map.put(root.right,root);
        traverse(root.right,map);
        return;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        boolean[]visited=new boolean[501];
        Map<TreeNode,TreeNode>parentMap=new HashMap<>();
        traverse(root,parentMap);
        // for(TreeNode key:parentMap.keySet()){
        //     System.out.println("KEY: "+key.val+" val: "+parentMap.get(key).val);
        // }
        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(target);
        visited[target.val]=true;
        int c=0;
        while(c<k && !q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode x=q.poll();
                if(x.left!=null &&!visited[x.left.val]){
                    q.add(x.left);
                    visited[x.left.val]=true;
                }
                if(x.right!=null && !visited[x.right.val]){
                    q.add(x.right);
                    visited[x.right.val]=true;
                }
                if(parentMap.containsKey(x) && !visited[parentMap.get(x).val]){
                    q.add(parentMap.get(x));
                    visited[parentMap.get(x).val]=true;
                }
            } 
             c++;
                // System.out.println(c);
                // for(TreeNode node:q){
                //     System.out.print(node.val+" ; ");
                // }
                // System.out.println("________");
                if(c==k)
                    break;
        }
        List<Integer>res=new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
}