class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>>map=new HashMap<>();
        for(List<String> ticket:tickets){
            String from=ticket.get(0),to=ticket.get(1);
            map.putIfAbsent(from,new PriorityQueue<>());
            PriorityQueue<String>pq=map.get(from);
            pq.offer(to);
        }
        List<String>res=new ArrayList<>();
        dfs(res,"JFK",map);
        Collections.reverse(res);
        return res;
    }
    void dfs(List<String>res,String from,Map<String,PriorityQueue<String>>map){
        PriorityQueue<String>pq=map.get(from);
        while(pq!=null && !pq.isEmpty()){
            String to =pq.poll();
            dfs(res,to,map);
        }
        res.add(from);
    }
}