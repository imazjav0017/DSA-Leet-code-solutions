class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        // Undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }

        // Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][k] == Integer.MAX_VALUE ||
                        dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }

                    dist[i][j] = Math.min(
                        dist[i][j],
                        dist[i][k] + dist[k][j]
                    );
                }
            }
        }

        int result = -1;
        int minReachable = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // <= handles tie by choosing larger city index
            if (count <= minReachable) {
                minReachable = count;
                result = i;
            }
        }

        return result;
    }
}