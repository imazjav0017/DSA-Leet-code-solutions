class Solution {
    static int maxVal(int[] piles){
        int ans=Integer.MIN_VALUE;
        for (int pile : piles) {
            ans = Math.max(ans, pile);
        }
        return ans;
    }
    static int totalHours(int[] arr, int mid){
        int total=0;
        for(int i=0;i<arr.length;i++){
            total+=Math.ceil((double)arr[i]/(double)mid);
        }
        return (int)total;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=maxVal(piles);
        int ans=Integer.MAX_VALUE;
        while(left<=right){
            int mid=(left+right)/2;
            int total=totalHours(piles,mid);

            if(total<=h){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}