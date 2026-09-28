class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int max=0;
        int left=0,right=n-1;
        while(left<right){
            int l=right-left;
            int h=Math.min(height[left],height[right]);
            max=Math.max(max,l*h);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}