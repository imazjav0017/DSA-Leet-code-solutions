class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1)
            return x;
        int left=2,right=x/2;
        while(left<=right){
            int mid=left+(right-left)/2;
            long sq=(long)mid*mid;
            if(sq==x)
                return mid;
            if(sq>x){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return right;
    }
}