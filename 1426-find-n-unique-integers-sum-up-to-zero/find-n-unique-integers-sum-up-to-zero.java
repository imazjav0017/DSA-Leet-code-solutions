class Solution {
    public int[] sumZero(int n) {
        int []res=new int[n];
        int idx=0;
        int itr=0;
        if(n%2!=0){
            res[0]=0;
            idx=1;
            itr=n/2;
        }
        else itr=n/2;
        for(int i=1;i<=itr;i++){
            res[idx]=i;
            idx++;
            res[idx]=i*-1;
            idx++;
        }
        return res;

    }
}