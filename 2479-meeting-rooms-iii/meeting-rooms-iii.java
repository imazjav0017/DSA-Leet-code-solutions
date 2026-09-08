class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer>freeRooms=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            freeRooms.offer(i);
        }
        PriorityQueue<long[]>busyRooms=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return Long.compare(a[0],b[0]);
            }
            return Long.compare(a[1],b[1]);
        });
        int[]count=new int[n];
        for(int[]meeting:meetings){
            long start=meeting[0],end=meeting[1];
            long duration=end-start;
            while(!busyRooms.isEmpty() && busyRooms.peek()[0]<=start){
                long[]finished=busyRooms.poll();
                freeRooms.offer((int)finished[1]);
            }
            int room;
            long newEnd;
            if(!freeRooms.isEmpty()){
                room=freeRooms.poll();
                newEnd=end;
            }
            else{
                long earliest[]=busyRooms.poll();
                long availableTime=earliest[0];
                room=(int)earliest[1];
                newEnd=availableTime+duration;
            }
            busyRooms.offer(new long[]{newEnd,room});
            count[room]++;
        }
        int answer=0;
        for(int room=1;room<n;room++){
            if(count[room]>count[answer]){
                answer=room;
            }
        }
        return answer;

    }
}