class Solution {
    class Key{
        int x,y;
        public Key(int x, int y){
            this.x=x;
            this.y=y;
        }
         @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Key)) return false;

        Key other = (Key) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    }
    public int maxEqualAdjacentPairs(int[] nums) {
        int ans=0;
        Map<Key,Integer>map=new HashMap<>();
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                ans++;
            }
            else{
                Key key=null;
                if(nums[i]<nums[i-1]){
                    key=new Key(nums[i],nums[i-1]);
                }
                else{
                    key=new Key(nums[i-1],nums[i]);
                }
                map.put(key,map.getOrDefault(key,0)+1);
            }
        }
        int max=0;
        for(Key key:map.keySet()){
            int freq=map.get(key);
            max=Math.max(max,freq);
        }
        return ans+max;
    }
}