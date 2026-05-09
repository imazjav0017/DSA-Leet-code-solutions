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
    Map<Integer,Integer>heights=new HashMap<>();
    Map<Integer,Integer>answers=new HashMap<>();
    int getHeight(TreeNode root){
        if(root==null)
            return -1;
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        int height = 1+Math.max(left,right);
        heights.put(root.val,height);
        return height;
    }
    void dfs(TreeNode root,int maxWithoutSubTree,int depth){
        if(root==null)
            return;
        answers.put(root.val,maxWithoutSubTree);
        int left=root.left==null?-1:heights.get(root.left.val);
        int right=root.right==null?-1:heights.get(root.right.val);
        if(root.left!=null){
            int maxWithoutLeft=Math.max(maxWithoutSubTree,1+depth+right);
            dfs(root.left,maxWithoutLeft,depth+1);
        }
        if(root.right!=null){
            int maxWithoutRight=Math.max(maxWithoutSubTree,1+depth+left);
            dfs(root.right,maxWithoutRight,depth+1);
        }
        return;
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        getHeight(root);
        dfs(root,0,0);
        int n=queries.length;
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=answers.get(queries[i]);
        }
        return ans;
    }
}