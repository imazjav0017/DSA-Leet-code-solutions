// nearest ---- BFS
//but bfs from each 1 to nearest 0 would be too much complexity
// rather to bfs from 0 to 1
class Solution {
    static int m, n;

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;

        int[][] ans = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Push all 0s into queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !vis[nr][nc]) {
                    ans[nr][nc] = ans[r][c] + 1;
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return ans;
    }
}