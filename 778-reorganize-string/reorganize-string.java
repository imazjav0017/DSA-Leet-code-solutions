class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        char[]arr=s.toCharArray();
        int[]count=new int[26];
        for(char c: arr){
            count[c-'a']++;
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        for(int i=0;i<26;i++){
            if(count[i]>0)
                pq.offer(new int[]{i,count[i]});
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