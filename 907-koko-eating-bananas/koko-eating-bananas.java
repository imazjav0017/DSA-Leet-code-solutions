class Solution {
    boolean canEat(int[]piles,int speed, int max){
        int hours=0;
        for(int i=0;i<piles.length;i++){
            hours+=piles[i]/speed;
            if(piles[i]%speed!=0)
                hours+=1;
            if(hours>max)
                return false;
        }
        return hours<=max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        for(int i=1;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }
        int left=1,right=max+1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canEat(piles,mid,h)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}