class Solution {
    boolean canDo(int[]time,long mid, int x){
        long sum=0;
        for(int i:time){
            sum+=mid/i;
        }
        return sum>=x;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int min=time[0];
        for(int t:time){
            min=Math.min(min,t);
        }
        long left=0,right=(long)min*totalTrips;
        while(left<right){
            long mid=left+(right-left)/2;
            if(canDo(time,mid,totalTrips))
                right=mid;
            else left=mid+1;
        }
        return left;
    }
}