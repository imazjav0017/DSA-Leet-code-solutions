class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer>freq=new HashMap<>();
        for(String w:words){
            freq.put(w,freq.getOrDefault(w,0)+1);
        }
        PriorityQueue<String>pq=new PriorityQueue<>((a,b)->{
            if(!freq.get(a).equals(freq.get(b))){
                return Integer.compare(freq.get(a),freq.get(b));
            }
            return b.compareTo(a);
        });
        for(String w: freq.keySet()){
            pq.offer(w);
            if(pq.size()>k)
                pq.poll();
        }
        List<String>res=new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(pq.poll());
        }
         Collections.reverse(res);
         return res;
    }
}