class Solution {
    public int scheduleCourse(int[][] courses) {
        int n=courses.length;
        Arrays.sort(courses,(a,b)->Integer.compare(a[1],b[1]));
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int totalTime=0;
        for(int[]c:courses){
            totalTime+=c[0];
            pq.offer(c[0]);
            if(totalTime>c[1]){
                totalTime-=pq.poll();
            }
        }
        return pq.size();
    }
}