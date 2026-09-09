class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        char[]arr=s.toCharArray();
        int[][]count=new int[26][2];
        for(char c: arr){
            int asci=c-'a';
            count[asci][0]=asci;
            count[asci][1]++;
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        for(int[]c:count){
            if(c[1]>0)
                pq.offer(c);
        }
        char[]res=new char[n];
        int idx=0;
        int[]prev=null;
        while(!pq.isEmpty()){
            int[]curr=pq.poll();
            res[idx++]=(char)('a'+ curr[0]);
            curr[1]--;
            if(prev!=null && prev[1]>0){
                pq.offer(prev);
            }
            prev=curr;
        }
        if(prev!=null && prev[1]>0)
            return "";
        else return String.valueOf(res);  
    }
}