class Solution {
    boolean dfs(
        int node,
        int[][] graph,
        boolean[] onPath,
        boolean[] safe,
        boolean[] unsafe
    ) {
        if (safe[node]) return true;
        if (unsafe[node]) return false;
        if (onPath[node]) return false;

        onPath[node] = true;

        for (int next : graph[node]) {
            if (!dfs(next, graph, onPath, safe, unsafe)) {
                onPath[node] = false;
                unsafe[node] = true;
                return false;
            }
        }

        onPath[node] = false;
        safe[node] = true;

        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] onPath = new boolean[n];
        boolean[] safe = new boolean[n];
        boolean[] unsafe = new boolean[n];

        List<Integer> result = new ArrayList<>();

        for (int node = 0; node < n; node++) {
            if (dfs(node, graph, onPath, safe, unsafe)) {
                result.add(node);
            }
        }

        return result;
    }
}