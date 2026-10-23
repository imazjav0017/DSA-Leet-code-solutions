class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();

    int rows, cols;

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        result = new ArrayList<>();

        rows = board.length;
        cols = board[0].length;

        // Step 1: Build Trie
        for (String word : words) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            node.word = word;
        }

        // Step 2: Start DFS from every cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root);
            }
        }

        return result;
    }

    void dfs(char[][] board, int r, int c, TrieNode node) {
        if (r < 0 || c < 0 || r >= rows || c >= cols) return;

        char ch = board[r][c];

        // Already visited
        if (ch == '#') return;

        TrieNode next = node.children[ch - 'a'];

        // No word has this prefix
        if (next == null) return;

        // Found a complete word
        if (next.word != null) {
            result.add(next.word);
            next.word = null; // Prevent duplicates
        }

        // Mark visited
        board[r][c] = '#';

        dfs(board, r + 1, c, next);
        dfs(board, r - 1, c, next);
        dfs(board, r, c + 1, next);
        dfs(board, r, c - 1, next);

        // Backtrack
        board[r][c] = ch;
    }
}
