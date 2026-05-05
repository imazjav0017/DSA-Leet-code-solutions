class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=Long.MIN_VALUE;
        Map<Integer,Long>prefixMap=new HashMap<>();
        long prefix=0;
        for(int i:nums){
            //Step 1: check if i-k or i+k exists
            //Step 2: if not : 
            if(prefixMap.containsKey(i-k)){
                sum=Math.max(sum,(prefix+i-prefixMap.get(i-k)));
            }
            if(prefixMap.containsKey(i+k)){
                sum=Math.max(sum,(prefix+i-prefixMap.get(i+k)));
            }
            prefixMap.put(i,Math.min(prefixMap.getOrDefault(i,Long.MAX_VALUE),prefix));
            prefix+=i;
        }
        return sum==Long.MIN_VALUE?0:sum;
    }
}