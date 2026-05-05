class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=Long.MIN_VALUE;
        Map<Integer,Long>prefixMap=new HashMap<>();
        long prefix=0;
        for(int i:nums){
            //Step 1: check if i-k
            //Step 2: check if i+k exists, both can exist, then i+k will give bigger sum.
            //step 3: if neither exists, then insert the current prefixvalue
            //however current i can exist already, so insert smallest prefix value as we do: 
            //prefix+i-Mapvalue , so we want mapValue to be smallest if duplicates exist.
            //if a match is found then we do current Prefix + current value (i) - prefix till the start
            //index we found

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