class Solution {
    String ans = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) return;

        char c = (char) ('a' + node.val);

        // Insert at front because we need leaf -> root
        path.insert(0, c);

        if (node.left == null && node.right == null) {
            String curr = path.toString();

            if (ans == null || curr.compareTo(ans) < 0) {
                ans = curr;
            }
        }

        dfs(node.left, path);
        dfs(node.right, path);

        // Backtrack
        path.deleteCharAt(0);
    }
}