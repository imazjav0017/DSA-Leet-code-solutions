class Solution {
    public int majorityElement(int[] nums) {
      HashMap<Integer,Integer>map=new HashMap<>();
      int n=nums.length;
      int num=nums[0];
      for(int i=0;i<n;i++){
        int count=map.getOrDefault(nums[i],0)+1;
        if(count>n/2)
            {
                num=nums[i];
                break;
            }
        map.put(nums[i],count);
      } 
      return num; 
    }
}