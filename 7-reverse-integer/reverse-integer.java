class Solution {
    public int reverse(int x) {
        long res=0;
        int sign=1;
        if(x<0)sign=-1;
        x=Math.abs(x);
        while(x!=0){
            int num=x%10;
            res=res*10+num;
            if(res*sign>Integer.MAX_VALUE)return 0;
            if(res*sign<Integer.MIN_VALUE)return 0;
            x/=10;
        }
        return (int)res*sign;
    }
}