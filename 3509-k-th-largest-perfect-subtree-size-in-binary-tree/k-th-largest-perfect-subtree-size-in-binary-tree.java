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
        public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        Collections.sort(res);
        if (k <= res.size()) {
            return (1 << res.get(res.size() - k)) - 1;
        }
        return -1;
    }

    private int dfs(TreeNode root, List<Integer> res) {
        if (root == null) return 0;
        int l = dfs(root.left, res), r = dfs(root.right, res);
        if (l == r && l >= 0) {
            res.add(l + 1);
            return l + 1;
        }
        return -1;
    }
}