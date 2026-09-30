class Entry{
    public String key,value;
    public int time;
    public Entry(String key, String value, int time){
        this.key=key;
        this.value=value;
        this.time=time;
    }
}
class TimeMap {
    Map<String,List<Entry>> map;
    public TimeMap() {
       map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
      List<Entry>list=map.getOrDefault(key,new ArrayList<>());
      list.add(new Entry(key,value,timestamp));
      map.put(key,list);
    }
    
    public String get(String key, int timestamp) {
        List<Entry>list=map.get(key);
        if(list==null)
            return "";
       int left=0;
       int right=list.size();
       while(left<right){
        int mid=left+(right-left)/2;
        if(list.get(mid).time>timestamp){
            right=mid;
        }
        else left=mid+1;
       }
       return left==0?"":list.get(left-1).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */