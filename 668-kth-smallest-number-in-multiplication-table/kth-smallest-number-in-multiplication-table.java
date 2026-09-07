class Solution {
    boolean canDo(int m,int n, int mid, int k){
        int c=0;
        int row=m,col=1;
        while(row>=1 && col<=n){
            if(mid>=row*col){
                c+=row;
                col++;
                if(c>=k) return true;
            }
            else row--;
        }
        return false;
    }
    public int findKthNumber(int m, int n, int k) {
        int left=1,right=m*n;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canDo(m,n,mid,k)){
                right=mid;
            }
            else left=mid+1;
        }
        return left;
    }
}