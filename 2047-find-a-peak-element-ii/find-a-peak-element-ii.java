class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int left=0,right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int max=0,maxI=0;
            for(int i=0;i<m;i++){
                max=Math.max(max,mat[i][mid]);
                if(max==mat[i][mid])
                    maxI=i;
            }
            if(mid!=0 && mat[maxI][mid-1]>max){
                right=mid-1;
            }
            else if(mid!=n-1 && mat[maxI][mid+1]>max){
                left=mid+1;
            }
            else
                return new int[]{maxI,mid};
        }
        return new int[]{0,0};
    }
}