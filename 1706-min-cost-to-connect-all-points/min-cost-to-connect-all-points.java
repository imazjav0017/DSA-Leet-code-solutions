class Solution {

    int[] parent;
    int[] rank;

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        // 1. Create every possible edge
        // edge = {cost, node1, node2}
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int cost =
                    Math.abs(points[i][0] - points[j][0]) +
                    Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{cost, i, j});
            }
        }

        // 2. Sort edges cheapest first
        edges.sort((a, b) -> Integer.compare(a[0], b[0]));

        // 3. Initialize DSU
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgesUsed = 0;

        // 4. Process cheapest edges
        for (int[] edge : edges) {

            int cost = edge[0];
            int u = edge[1];
            int v = edge[2];

            // Already connected → taking edge would create cycle
            if (find(u) == find(v)) {
                continue;
            }

            // Connect the components
            union(u, v);

            totalCost += cost;
            edgesUsed++;

            // MST always contains exactly n - 1 edges
            if (edgesUsed == n - 1) {
                break;
            }
        }

        return totalCost;
    }

    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }

        return parent[x];
    }

    private void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return;

        // Union by rank
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        }
        else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        }
        else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}