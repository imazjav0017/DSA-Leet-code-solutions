class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int l=0,r=m-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]<target){
                l=mid+1;
            }
            else {
                r=mid-1;
            }
        }
        if(r>=0)l--;
        int l1=0;
        r=n-1;
        while(l1<=r){
            int mid=(l1+r)/2;
            if(matrix[l][mid]==target)return true;
            if(matrix[l][mid]<target){
                l1=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return false;
    }
}