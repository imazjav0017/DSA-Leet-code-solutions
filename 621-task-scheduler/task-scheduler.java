class Solution {
    public int leastInterval(char[] tasks, int n) {
        int s=tasks.length;
        int[]count=new int[26];
        for(char t: tasks){
            count[t-'A']++;
        }
        //[task, countLeft, lastCompletedAt]
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++){
            if(count[i]>0){
                pq.offer(count[i]);
            }
        }
        int time=0;
        Queue<int[]>cooldown=new LinkedList<>();
        while(!pq.isEmpty() || !cooldown.isEmpty()){
           time++;
           if(!cooldown.isEmpty() && cooldown.peek()[1]<=time){
            pq.offer(cooldown.poll()[0]);
           }
           if(!pq.isEmpty()){
            int remaining=pq.poll()-1;
            if(remaining>0){
                cooldown.offer(new int[]{remaining,time+n+1});
            }
           }
        }
        return time;
    }
}