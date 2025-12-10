class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int max_area=0;
        int left=0, right=n-1;
        while(left<right){
           int leftHeight = height[left], rightHeight = height[right];
            int area = Math.min(leftHeight, rightHeight) * (right-left);
            max_area = Math.max(area, max_area);

            if(leftHeight < rightHeight)left++;
            else right--;
        }
        return max_area;
    }
}