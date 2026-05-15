/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer>res=new ArrayList<>();
    void dfs(Node root){
        if(root==null)
            return;
        res.add(root.val);
        List<Node>children=root.children;
        if(children!=null){
            for(Node node:children){
                dfs(node);
            }
        }
        return;
    }
    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }
}