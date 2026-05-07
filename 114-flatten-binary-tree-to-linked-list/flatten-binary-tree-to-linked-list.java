class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;

                // Find rightmost node of left subtree
                while (prev.right != null) {
                    prev = prev.right;
                }

                // Attach original right subtree
                prev.right = curr.right;

                // Move left subtree to right
                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }
}