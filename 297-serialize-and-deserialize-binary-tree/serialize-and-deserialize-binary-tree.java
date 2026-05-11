public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder build = new StringBuilder();
        serializeHelper(root, build);
        return build.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder build) {
        if (root == null) {
            build.append("#,");
            return;
        }

        build.append(root.val).append(",");
        serializeHelper(root.left, build);
        serializeHelper(root.right, build);
    }

    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        int[] index = new int[1];
        return deserializeHelper(tokens, index);
    }

    private TreeNode deserializeHelper(String[] tokens, int[] index) {
        String token = tokens[index[0]++];

        if (token.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(token));
        root.left = deserializeHelper(tokens, index);
        root.right = deserializeHelper(tokens, index);

        return root;
    }
}