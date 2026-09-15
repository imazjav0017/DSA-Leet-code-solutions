class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer>stack=new ArrayDeque<>();
        int max=0;
        for(int i=0;i<=heights.length;i++){
            int h=i==heights.length?0:heights[i];
            while(!stack.isEmpty() && h<heights[stack.peek()]){
                int currentHeight=heights[stack.pop()];
                int left=stack.isEmpty()?-1:stack.peek();
                int width=i-left-1;
                max=Math.max(max,width*currentHeight);
            }
            stack.push(i);
        }
        return max;
    }
}