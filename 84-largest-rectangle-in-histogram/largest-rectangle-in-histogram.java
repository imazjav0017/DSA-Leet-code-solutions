class Solution {
    public int largestRectangleArea(int[] heights) {
       int n=heights.length;
       Deque<Integer>stack=new ArrayDeque<>();
       int maxArea=0;
       for(int i=0;i<=n;i++){
        int h=i<n?heights[i]:-1;
        while(!stack.isEmpty() && h<heights[stack.peek()]){
            int h1=heights[stack.pop()];
            int left=stack.isEmpty()?-1:stack.peek();
            int length=i-left-1;
            maxArea=Math.max(maxArea,length*h1);
        }
        if(i<n)stack.push(i);
       }
       return maxArea;
    }
}