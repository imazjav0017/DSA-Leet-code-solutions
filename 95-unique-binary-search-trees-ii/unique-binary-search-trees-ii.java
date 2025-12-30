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
    public List<TreeNode> generate(int left,int right){
        if(left==right)
            {
                ArrayList<TreeNode> list = new ArrayList<>();
                list.add(new TreeNode(left));
                return list;
            }
            if(left>right){
                ArrayList<TreeNode> list = new ArrayList<>();
                list.add(null);
                return list;
            }
            ArrayList<TreeNode> list = new ArrayList<>();
            for(int v=left;v<=right;v++){
                List<TreeNode> leftTree=generate(left,v-1);
                List<TreeNode> rightTree=generate(v+1,right);
                for(TreeNode l:leftTree){
                    for(TreeNode r: rightTree){
                        TreeNode root=new TreeNode(v,l,r);
                        list.add(root);
                    }
                }
            }
              return list;
    }
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }
}