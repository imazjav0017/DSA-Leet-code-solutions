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
    public List<TreeNode>findAncestors(TreeNode root,int k){
          List<TreeNode> res= new ArrayList<>();
          if(root==null){
            return null;
        }
        if(root.val==k){
            res.add(root);
            return res;
        }
        List<TreeNode> left=findAncestors(root.left,k);
        List<TreeNode> right=findAncestors(root.right,k);
        if(left==null && right==null){
            return null;
        }
        res.add(root);
        if(left!=null){
            for(TreeNode i:left){
                res.add(i);
            }
        }
        else if(right!=null){
            for(TreeNode i:right){
                res.add(i);
            }
        }
        return res;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>res1=findAncestors(root,p.val);
        List<TreeNode>res2=findAncestors(root,q.val);
        // for(TreeNode i: res1){
        //     System.out.println(i.val+",");
        // }
        // System.out.println("________");
        // for(TreeNode i: res2){
        //     System.out.println(i.val+",");
        // }
        int min=Math.min(res1.size(),res2.size());
        TreeNode lca=null;
        for(int i=0;i<min && i<res1.size() && i<res2.size();i++){
            if(res1.get(i).val==res2.get(i).val){
                lca=res1.get(i);
            }
            else
                break;
        }
        return lca;
        
    }
}