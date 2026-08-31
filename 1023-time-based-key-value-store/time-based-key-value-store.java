class Entry{
    public String value;
    public int timeStamp;
    public Entry(String value,int timeStamp){
        this.value=value;
        this.timeStamp=timeStamp;
    }
}
class TimeMap {
    Map<String,List<Entry>>map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Entry>entries=map.getOrDefault(key,new ArrayList<>());
        entries.add(new Entry(value,timestamp));
        map.put(key,entries);
    }
    
    public String get(String key, int timestamp) {
        List<Entry>entries=map.get(key);
        if(entries==null)
            return "";
        int left=0,right=entries.size();
        while(left<right){
            int mid=left+(right-left)/2;
            if(entries.get(mid).timeStamp>timestamp)
                right=mid;
            else left=mid+1;
        }
        if(left==0)
            return "";
        return entries.get(left-1).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */