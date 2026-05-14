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
    Map<Integer,Integer>map=new HashMap<>();
    int postIdx=0;
    TreeNode buildTree(int[]postOrder,int left,int right){
        if(left>right)
            return null;
        int rootVal=postOrder[postIdx];
        postIdx--;
        int mid=map.get(rootVal);
        TreeNode root=new TreeNode(rootVal);
        root.right=buildTree(postOrder,mid+1,right);
        root.left=buildTree(postOrder,left,mid-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        postIdx=postorder.length-1;
        return buildTree(postorder,0,postorder.length-1);
    }
}