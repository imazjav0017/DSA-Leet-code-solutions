class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer>firstSeen=new HashMap<>();
        firstSeen.put(0,-1);
        int balance=0;
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            balance+=nums[i]==0?-1:1;
            if(firstSeen.containsKey(balance)){
                maxLen=Math.max(maxLen,i-firstSeen.get(balance));
            }
            else{
                firstSeen.put(balance,i);
            }
        }
        return maxLen;
    }
}