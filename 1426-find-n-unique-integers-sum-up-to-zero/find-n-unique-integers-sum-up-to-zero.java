class Solution {
    public int[] sumZero(int n) {
        int []res=new int[n];
        int idx=0;
        int itr=n/2;
        if(n%2!=0){
            res[0]=0;
            idx=1;
        }
        for(int i=1;i<=itr;i++){
            res[idx]=i;
            idx++;
            res[idx]=i*-1;
            idx++;
        }
        return res;

    }
}