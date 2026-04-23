class Solution {
    public boolean canChange(String start, String target) {
        char[]arr=start.toCharArray();
        char[]tgt=target.toCharArray();
        int n=tgt.length;
        List<Integer>lefts=new ArrayList<>();
        List<Integer>rights=new ArrayList<>();
        for(int i=0;i<n;i++){
            char c=tgt[i];
            if(c=='L')
                lefts.add(i);
            else if(c=='R')
                rights.add(i);
        }
        int lr=0;
        for(int ti:lefts){
            if(!(arr[ti]=='L'||arr[ti]=='_'))
                return false;
            lr=ti;
            while(lr<n){
                if(arr[lr]=='L')
                    {
                        break;
                    }
                else if(arr[lr]=='R')
                    return false;
                lr++;
            }
            if(lr<n)
                {
                    arr[ti]='L';
                    if(ti!=lr)arr[lr]='_';
                    lr++;
                }
            else
                return false;
        }
        // System.out.println(new String(arr));
        int rs=rights.size();
        int rr=n-1;
        for(int t=rs-1;t>=0;t--){
            int ti=rights.get(t);
            if(!(arr[ti]=='R'||arr[ti]=='_'))
                return false;
            rr=ti;
            while(rr>=0){
                if(arr[rr]=='R')
                    {
                        break;
                    }
                else if(arr[rr]=='L')
                    return false;
                rr--;
            }
            if(rr>=0)
                {
                    arr[ti]='R';
                    if(ti!=rr)arr[rr]='_';
                    rr--;
                }
            else
                return false;
            } 
    
    // System.out.println(new String(arr));
    return target.equals(new String(arr));
    }
}