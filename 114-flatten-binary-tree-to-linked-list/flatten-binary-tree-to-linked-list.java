class Solution {
    public void flatten(TreeNode root) {
       TreeNode curr=root;
       while(curr!=null){
        TreeNode prev=curr.left;
        if(prev!=null){
             while(prev.right!=null){
            prev=prev.right;
        }
        prev.right=curr.right;
        curr.right=curr.left;
        curr.left=null;
        }
        curr=curr.right;
       }
    }
}