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
    int pIdx=0;
    Map<Integer,Integer>inOrderMap=new HashMap<>();
    TreeNode build(int[]preorder,int left,int right){
        if(left>right)
            return null;
        int rootval=preorder[pIdx];
        pIdx++;
        TreeNode root=new TreeNode(rootval);
        int inOrderIdx=inOrderMap.get(rootval);
        root.left=build(preorder,left,inOrderIdx-1);
        root.right=build(preorder,inOrderIdx+1,right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
}