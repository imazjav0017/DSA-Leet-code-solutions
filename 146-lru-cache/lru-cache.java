class LRUCache {
    class Node{
        int key,value;
        Node prev,next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Map<Integer,Node>map;
    Node left,right;
    int capacity;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
        left=new Node(0,0);
        right=new Node(0,0);
        left.next=right;
        right.prev=left;
    }
    
    public int get(int key) {
        Node node=map.get(key);
        if(node==null)
            return -1;
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            remove(node);
            insert(node);
            return;
        }
        else{
            Node node=new Node(key,value);
            map.put(key,node);
            insert(node);
            if(map.size()>capacity){
                Node lru=left.next;
                remove(lru);
                map.remove(lru.key);
            }
        }
    }
    void remove(Node node){
        Node prev=node.prev;
        Node next=node.next;
        prev.next=next;
        next.prev=prev;
    }
    void insert(Node node){
        Node prev=right.prev;
        prev.next=node;
        node.prev=prev;
        node.next=right;
        right.prev=node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */