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
    int idx=0;
    TreeNode dfs(Map<Integer,Integer>inorderMap,int[]preorder,int start,int end){
        if(start>end)
            return null;
        int val=preorder[idx++];
        TreeNode root=new TreeNode(val);
        int iIdx=inorderMap.get(val);
        root.left=dfs(inorderMap,preorder,start,iIdx-1);
        root.right=dfs(inorderMap,preorder,iIdx+1,end);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer>inorderMap=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<n;i++){
            inorderMap.put(inorder[i],i);
        }
        return dfs(inorderMap,preorder,0,n-1);
    }
}