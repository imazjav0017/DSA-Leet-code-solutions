class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n=quality.length;
       // [ratio, quality]
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }
        Arrays.sort(workers, (a, b) ->
            Double.compare(a[0], b[0])
        );
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int totalQuality=0;
        double answer=Double.MAX_VALUE;
        for(int i=0;i<workers.length;i++){
            double ratio=workers[i][0];
            totalQuality+=workers[i][1];
            pq.offer((int)workers[i][1]);
            if(pq.size()>k){
                totalQuality-=pq.poll();
            }
            if(pq.size()==k){
                double cost = ratio*totalQuality;
                answer=Math.min(answer,cost);
            }
        }
        return answer;
    }
}