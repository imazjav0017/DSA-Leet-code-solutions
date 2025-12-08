class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int cols=grid[0].length;
        int rows=grid.length;
        for(int i=0;i<rows;i++){
            Arrays.sort(grid[i]);
        }
        int sum=0;
        for(int i=0;i<cols;i++){
            int max=0;
            for(int j=0;j<rows;j++){
                if(grid[j][i]>max)
                    max=grid[j][i];
            }
            sum+=max;
        }
        return sum;
    }
}