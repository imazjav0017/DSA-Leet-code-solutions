class Proc{
    int id,start,time;
    Proc(int id, int start, int time){
        this.id=id;
        this.start=start;
        this.time=time;
    }
}
class Solution {
    public int[] getOrder(int[][] tasks) {
        Queue<Proc>q=new LinkedList<>();
        PriorityQueue<Proc>pq=new PriorityQueue<>((a,b)->{
            if(a.time!=b.time)
                return Integer.compare(a.time,b.time);
            return Integer.compare(a.id,b.id);
        });
        Proc[]procs=new Proc[tasks.length];
        for(int i=0;i<tasks.length;i++){
            procs[i]=new Proc(i,tasks[i][0],tasks[i][1]);
        }
        Arrays.sort(procs,(a,b)->Integer.compare(a.start,b.start));
        for(Proc p:procs){
            q.offer(p);
        }
        int[]res=new int[tasks.length];
        int idx=0;
        int time=q.peek().start;
        while(!q.isEmpty() || !pq.isEmpty()){
            while(!q.isEmpty() && q.peek().start<=time){
                pq.offer(q.poll());
            }
            if(!pq.isEmpty()){
                Proc done=pq.poll();
                time+=done.time;
                res[idx++]=done.id;
            }else{
                time=q.peek().start;
            }
        }
        return res;
    }
}