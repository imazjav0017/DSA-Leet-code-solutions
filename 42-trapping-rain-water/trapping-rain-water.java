class Solution {
    public int trap(int[] height) {
        int units=0;
        Deque<Integer>stack=new ArrayDeque<>();
        for(int i=0;i<height.length;i++){
            int h=height[i];
            while(!stack.isEmpty() && h>height[stack.peek()]){
                int last=stack.pop();
                if(!stack.isEmpty()){
                    int curHeight=Math.min(h,height[stack.peek()])-height[last];
                    int w=i-stack.peek()-1;
                    units+=w*curHeight;
                }
            }
            stack.push(i);
        }
        return units;
    }
}