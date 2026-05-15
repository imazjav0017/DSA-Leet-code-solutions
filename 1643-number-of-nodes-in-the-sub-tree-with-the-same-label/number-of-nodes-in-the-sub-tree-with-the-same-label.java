class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] ans = new int[n];

        dfs(0, -1, graph, labels, ans);

        return ans;
    }

    private int[] dfs(int node, int parent, List<Integer>[] graph, String labels, int[] ans) {
        int[] count = new int[26];

        for (int child : graph[node]) {
            if (child == parent) continue;

            int[] childCount = dfs(child, node, graph, labels, ans);

            for (int i = 0; i < 26; i++) {
                count[i] += childCount[i];
            }
        }

        int labelIndex = labels.charAt(node) - 'a';
        count[labelIndex]++;

        ans[node] = count[labelIndex];

        return count;
    }
}