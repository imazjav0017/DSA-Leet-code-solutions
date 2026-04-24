class Solution {
    int next(int n){
        int sum=0;
        while(n>0){
            int num=n%10;
            sum+=num*num;
            n/=10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n,fast=n;
        do{
            slow=next(slow);
            fast=next(next(fast));
        }while(slow!=fast);
        return slow==1;
    }
}