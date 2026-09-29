class Solution {
    boolean canEat(int speed,int[]piles,int h){
       int time=0;
       for(int x:piles){
        time+=x/speed;
        if(x%speed!=0)
            time+=1;
        if(time>h)
            return false;
       }
       return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
       int left=1;
       int right=piles[0];
       for(int x:piles){
        right=Math.max(right,x);
       }
       while(left<right){
        int mid=left+(right-left)/2;
        if(canEat(mid,piles,h)){
            right=mid;
        }else{
            left=mid+1;
        }
       }
        return left;
    }
       
}