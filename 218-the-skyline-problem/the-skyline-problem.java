class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]>events=new ArrayList<>();
        for(int[]b:buildings){
            events.add(new int[]{b[0],-b[2]});
            events.add(new int[]{b[1],b[2]});
        }
        events.sort((a,b)->{
            if(a[0]!=b[0])
                return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer,Integer>removed=new HashMap<>();
        pq.offer(0);
        int prevHeight=0;
        List<List<Integer>>res=new ArrayList<>();
        for(int[]event:events){
            int x=event[0];
            int h=event[1];
            if(h<0){
                pq.offer(-h);
            }
            else{
                removed.put(h,removed.getOrDefault(h,0)+1);
            }
            while(removed.getOrDefault(pq.peek(),0)>0){
                int top=pq.poll();
                removed.put(top,removed.get(top)-1);
            }
            int currHeight=pq.peek();
            if(currHeight!=prevHeight){
                res.add(Arrays.asList(x,currHeight));
                prevHeight=currHeight;
            }
        }
        return res;
    }
}