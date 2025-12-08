class Solution {
    int getNumber(char c){
        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
    public int romanToInt(String s) {
       int res=0;
       int n=s.length();
       boolean ended=false;
       for(int i=0;i<n-1;i++){
        char c=s.charAt(i);
        char c1=s.charAt(i+1);
        int n1=getNumber(c);
        int n2=getNumber(c1);
        if(n1>=n2){
            res+=n1;
        }
        else{
            res+=(n2-n1);
            i++;
            if(i==n-1)ended=true;
        }
       }
       if(!ended){
        int n1=getNumber(s.charAt(n-1));
        res+=n1;
       }
       return res;
    }
}