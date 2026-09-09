class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res=new StringBuilder();
        PriorityQueue<int[]>pq=new PriorityQueue<>((x,y)->Integer.compare(y[0],x[0]));
        if(a>0)
            pq.offer(new int[]{a,'a'});
        if(b>0)
            pq.offer(new int[]{b,'b'});
        if(c>0)
            pq.offer(new int[]{c,'c'});
        int[]prev=null;
        int n=0;
        while(!pq.isEmpty()){
            int[]curr=pq.poll();
            if(n>=2 && res.charAt(n-1)==curr[1] && res.charAt(n-2)==curr[1]){
                prev=curr;
                if(pq.isEmpty())
                    break;
                int[]next=pq.poll();
                res.append((char)next[1]);
                n++;
                next[0]--;
                if(next[0]>0)pq.offer(next);
                pq.offer(prev);
            }
            else{
                res.append((char)curr[1]);
                n++;
                curr[0]--;
                if(curr[0]>0)pq.offer(curr);
            }
        }
        return res.toString();
    }
}