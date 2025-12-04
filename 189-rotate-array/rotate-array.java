class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(n==1)return;
        int[]copy=new int[n];
        while(k>n){
            k-=n;
        };
        for(int i=0;i<n;i++){
            int j=i+k>=n?i+k-n:i+k;
            copy[j]=nums[i];
        }
        for(int i=0;i<n;i++){
            nums[i]=copy[i];
        }
    }
}