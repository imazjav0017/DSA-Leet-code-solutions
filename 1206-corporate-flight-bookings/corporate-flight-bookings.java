class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[]diff=new int[n+2];
        for(int[]booking:bookings){
            int start=booking[0],end=booking[1],number=booking[2];
            diff[start-1]+=number;
            diff[end]-=number;
        }
        int curr=0;
        for(int i=0;i<n;i++){
            diff[i]=diff[i]+curr;
            curr=diff[i];
        }
       return Arrays.copyOfRange(diff, 0, n);
    }
}