class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer>remainder=new HashMap<>();
        remainder.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem=((sum%k)+k)%k;
            if(remainder.containsKey(rem)){
                if(i-remainder.get(rem)>=2)
                    return true;
            }
            else
            remainder.put(rem,i);
        }
        return false;
    }
}