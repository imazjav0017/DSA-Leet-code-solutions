class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetTime = times[targetFriend][0];
        Arrays.sort(times,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        //[Leaving time, chair]
        PriorityQueue<int[]>heap=new PriorityQueue<>((a,b)->{
            
                return Integer.compare(a[0],b[0]);
          
        });
        for(int i=0;i<times.length;i++){
            pq.offer(i);
        }
        for(int[]time:times){
            while(!heap.isEmpty() && heap.peek()[0]<=time[0]){
                int[]left=heap.poll();
                pq.offer(left[1]);
            }
            int chair=pq.poll();
            if(time[0]==targetTime)
                return chair;
            heap.offer(new int[]{time[1],chair});
        }
        return 0;
    }
}