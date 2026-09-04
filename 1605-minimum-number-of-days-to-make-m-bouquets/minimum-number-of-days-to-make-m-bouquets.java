class Solution {
    boolean canDo(int[]bloomDay, int day, int m, int k){
        int count=0;
        int flowers=0;
        for(int b:bloomDay){
            if(b<=day){
                flowers++;
                if(flowers==k){
                    count++;
                    flowers=0;
                }
            }else{
                flowers=0;
            }
        }
        return count>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int min=bloomDay[0],max=bloomDay[0];
        if((long)m*k>bloomDay.length)
            return -1;
        for(int b:bloomDay){
            min=Math.min(min,b);
            max=Math.max(max,b);
        }
        int left=min,right=max;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canDo(bloomDay,mid,m,k))
                right=mid;
            else left=mid+1;
        }
        return left;
    }
}