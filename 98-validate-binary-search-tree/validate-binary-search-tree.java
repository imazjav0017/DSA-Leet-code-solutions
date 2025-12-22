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
    public Integer min(Integer a, Integer b, Integer c, Integer d, Integer e){
        if(b==null){
            b=a;
        }
        if(c==null)
        {
            c=a;
        }
        if(d==null)d=a;
        if(e==null)e=a;
        if(a<=b && a<=c && a<=d && a<=e)
            return a;
        if(b<=a && b<=c && b<=d && b<=e)
            return b;
        if(c<=a && c<=b && c<=d && c<=e)
            return c;
        if(d<=a && d<=b && d<=c && d<=e)
            return d;
        return e;
    }
     public Integer max(Integer a, Integer b, Integer c, Integer d, Integer e){
        if(b==null){
            b=a;
        }
        if(c==null)
        {
            c=a;
        }
        if(d==null)d=a;
        if(e==null)e=a;
        if(a>=b && a>=c && a>=d && a>=e)
            return a;
        if(b>=a && b>=c && b>=d && b>=e)
            return b;
        if(c>=a && c>=b && c>=d && c>=e)
            return c;
        if(d>=a && d>=b && d>=c && d>=e)
            return d;
        return e;
    }
    public Integer[]isValid(TreeNode root){
       if(root==null)
       {
        return new Integer[]{1,null,null};
       }
       Integer[]lhs=isValid(root.left);
       Integer maxleft=lhs[1]==null?null:Math.max(lhs[1],lhs[2]);
       Integer minleft=lhs[1]==null?null:Math.min(lhs[1],lhs[2]);
       Integer[]rhs=isValid(root.right);
       Integer minright=rhs[1]==null?null:Math.min(rhs[1],rhs[2]);
       Integer maxright=rhs[1]==null?null:Math.max(rhs[1],rhs[2]);
       boolean isV= lhs[0]==1 && (maxleft==null||maxleft<root.val)&& rhs[0]==1 
       && (minright==null||minright>root.val);
       Integer m1=min(root.val,
       minleft,maxleft,minright,maxright);
       Integer m2=max(root.val,minleft,maxleft,minright,maxright);
    //    System.out.println(minleft+","+maxleft+","+minright+","+maxright);
    //    System.out.println(m1+": "+m2);
       Integer[]res=new Integer[]{isV?1:0,m1,m2};
    //    System.out.println(root.val+":"+Arrays.toString(res));
       return res;
        
    }
    public boolean isValidBST(TreeNode root) {
        Integer[]x=isValid(root);
        return x[0]==1;
    }
}