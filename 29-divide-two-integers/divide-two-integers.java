class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        boolean negative= (dividend<0) != (divisor<0);
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        long quotient=0;
        while(a>=b){
            long value=b;
            long count=1;
            while((value<<1)<=a){
                value<<=1;
                count<<=1;
            }
            a-=value;
            quotient+=count;
        }
        if(negative){
            quotient=-quotient;
        }
        return (int)quotient;

    }
}