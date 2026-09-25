class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer>set=new HashSet<>();
       for(int i:nums){
        set.add(i);
       }
       int max=0;
       for(int i:set){
        if(!set.contains(i-1)){
            int current=i;
            int len=1;
            while(set.contains(current+1)){
                current++;
                len++;
            }
            max=Math.max(max,len);
        }
       }
       return max;
    }
}