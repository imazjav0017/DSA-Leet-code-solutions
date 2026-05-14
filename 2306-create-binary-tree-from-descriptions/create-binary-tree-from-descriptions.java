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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode>map=new HashMap<>();
        Set<Integer>set=new HashSet<>();
        for(int[]arr:descriptions){
            int parent=arr[0],child=arr[1];
            boolean isLeft=arr[2]==1;
            TreeNode parentNode=map.getOrDefault(parent,new TreeNode(parent));
            TreeNode childNode=map.getOrDefault(child,new TreeNode(child));
            set.add(child);
            map.put(parent,parentNode);
            map.put(child,childNode);
            if(isLeft)parentNode.left=childNode;
            else parentNode.right=childNode;
        }
        TreeNode root=null;
        for(int i:map.keySet()){
            if(!set.contains(i))
                {
                    root=map.get(i);
                    return root;
                }
        }
        return root;
    }
}