class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int sign=1;
        long num=0;
        int i=0;
        for(char ch:s.toCharArray()){
            if(i==0 && ch=='-')
            {
                sign=-1;
                i++;
                continue;
            }
            if(i==0 && ch=='+'){
                i++;
                continue;
            }
            if(!Character.isDigit(ch)){
                break;
            }
            num=num*10+Integer.parseInt(String.valueOf(ch));
            if(sign*num>Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(sign*num <Integer.MIN_VALUE)return Integer.MIN_VALUE;
            i++;
        }
       return (int)num*sign;
    }
}