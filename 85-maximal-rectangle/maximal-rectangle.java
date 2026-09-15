class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[]heights=new int[n];
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }
                else{
                    heights[j]=0;
                }
            }
        max=Math.max(max,findMaxArea(heights));
        }
        return max;
    }
    int findMaxArea(int[]heights){
        int max=0;
        Deque<Integer>stack=new ArrayDeque<>();
        for(int i=0;i<=heights.length;i++){
            int h=i==heights.length?0:heights[i];
            while(!stack.isEmpty() && h<heights[stack.peek()]){
                int ch=heights[stack.pop()];
                int left=stack.isEmpty()?-1:stack.peek();
                int w=i-left-1;
                max=Math.max(max,w*ch);
            }
            if(i<heights.length)
                stack.push(i);
        }
        return max;
    }
}