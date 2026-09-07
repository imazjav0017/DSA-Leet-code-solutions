class Solution {
    boolean canDo(int[][]matrix,int mid,int k){
        int c=0;
        int row=matrix.length-1,col=0;
        while(row>=0 && col<matrix.length){
            if(matrix[row][col]<=mid){
                c+=row+1;
                if(c>=k)return true;
                col++;
            }
            else{
                row--;
            }
        }
        return false;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int left=matrix[0][0],right=matrix[matrix.length-1][matrix.length-1];
        while(left<right){
            int mid=left+(right-left)/2;
            if(canDo(matrix,mid,k)){
                right=mid;
            }
            else left=mid+1;
        }
        return left;
    }
}