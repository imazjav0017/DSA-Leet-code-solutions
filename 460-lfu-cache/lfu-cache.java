class LFUCache {
    class Node {
        int value,freq;
        Node(int value, int freq){
            this.value=value;
            this.freq=freq;
        }
    }
    int capacity,minFreq;
    Map<Integer,Node>nodes=new HashMap<>();
    Map<Integer,LinkedHashSet<Integer>>freqMap=new HashMap<>();
    public LFUCache(int capacity) {
        this.capacity=capacity;
    }
    private void updateFreq(int key){
        Node node=nodes.get(key);
        int freq=node.freq;
        freqMap.get(freq).remove(key);
        if(freq==minFreq && freqMap.get(freq).isEmpty()){
            minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq,f->new LinkedHashSet<>()).add(key);
    }
    public int get(int key) {
        if(!nodes.containsKey(key))
            return -1;
        updateFreq(key);
        return nodes.get(key).value;
    }
    
    public void put(int key, int value) {
        if(capacity==0)
            return;
        if(nodes.containsKey(key)){
            updateFreq(key);
            nodes.get(key).value=value;
            return;
        }
        if(nodes.size()==capacity){
            LinkedHashSet<Integer> group=freqMap.get(minFreq);
            int evictKey=group.iterator().next();
            group.remove(evictKey);
            nodes.remove(evictKey);
        }
        nodes.put(key,new Node(value,1));
        freqMap.computeIfAbsent(1,f->new LinkedHashSet<>()).add(key);
        minFreq=1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */