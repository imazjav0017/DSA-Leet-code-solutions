class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>freq=new HashMap<>();
        for(int i: nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->
        Integer.compare(freq.get(a),freq.get(b)));
        for(int key:freq.keySet()){
            pq.offer(key);
            if(pq.size()>k)
                pq.poll();
        }
        int[]res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.poll();
        }
        return res;
    }
}