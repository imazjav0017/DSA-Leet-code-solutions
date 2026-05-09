class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            Integer[] level = new Integer[size];

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                int index = leftToRight ? i : size - 1 - i;
                level[index] = node.val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            res.add(Arrays.asList(level));
            leftToRight = !leftToRight;
        }

        return res;
    }
}