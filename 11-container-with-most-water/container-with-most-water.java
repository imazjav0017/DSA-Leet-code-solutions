class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int maxArea=0;
        int start=0, end=n-1;
        while(start<end){
            //System.out.println("Start: "+start+" End: "+end);
            int area=(end-start)*Math.min(height[start],height[end]);
            //System.out.println("AREA: "+area+" Max Area:"+maxArea);
            if(height[start]<height[end]){
                start++;
            }
            else end--;
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}