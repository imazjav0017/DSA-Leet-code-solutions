class Solution {
    private boolean isSubIsland(int[][] grid1, int[][] grid2, int x, int y) {
        if (x < 0 || x >= grid2[0].length || y < 0 || y >= grid2.length) return true;
        if (grid2[y][x] == 0) return true;
        grid2[y][x] = 0;
        boolean isLandOnGrid1 = grid1[y][x] == 1;
        boolean left = isSubIsland(grid1, grid2, x - 1, y);
        boolean right = isSubIsland(grid1, grid2, x + 1, y);
        boolean bottom = isSubIsland(grid1, grid2, x, y + 1);
        boolean top = isSubIsland(grid1, grid2, x, y - 1);
        return isLandOnGrid1 && left && right && bottom && top;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int width = grid1[0].length;
        int height = grid1.length;
        int ans = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (grid2[y][x] == 1) {
                    if (isSubIsland(grid1, grid2, x, y)) ans++;
                }
            }
        }
        return ans;
    }
}