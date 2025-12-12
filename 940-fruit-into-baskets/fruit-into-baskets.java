class Solution {
    public int totalFruit(int[] fruits) {
       int low = 0 , high = 0; 
        int maxlen=0 , n = fruits.length;
        Map<Integer , Integer> map  = new HashMap<>();
        while(high<n){
            map.put(fruits[high],map.getOrDefault(fruits[high],0)+1);
            while(map.size()>2){
                map.put(fruits[low],map.getOrDefault(fruits[low],0)-1);
                if(map.get(fruits[low])==0){
                    map.remove(fruits[low]);
                }
                low++;
            }
            maxlen = Math.max(maxlen, high-low+1);
            high++;
        }
        return maxlen;
    }
}