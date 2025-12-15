class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int l=1,r=Arrays.stream(piles).max().getAsInt();
        int min=r;
        while(l<=r){
            int mid=(l+r)/2;
            long hours=0;
            for(int i=0;i<n;i++){
                hours+=piles[i]/mid;
                if(piles[i]%mid!=0)hours++;
            }
            
            if(hours<=h){
                min=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return min;
    }
}