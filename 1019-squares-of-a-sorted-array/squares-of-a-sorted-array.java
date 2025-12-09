class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int p1=0;
        int p2=n-1;
        int[]res=new int[n];
        int pos=n-1;
        while(p1<=p2){
            int n1=nums[p1],n2=nums[p2];
            if(n1<0){
                n1=-1*n1;
            }
            if(n2<0){
                n2=-1*n2;
            }
            int max=Math.max(n1,n2);
            res[pos]=max*max;
            pos--;
            if(max==n1)p1++;
            else p2--;
        }
        return res;
    }
}