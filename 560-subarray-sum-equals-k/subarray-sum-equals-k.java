class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[]prefix=new int[n+1];
        int sum=0;
        int res=0;
        prefix[0]=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=nums[i];
            prefix[i+1]=sum;
        }
        for(int i=0;i<=n;i++){
            if(map.containsKey(prefix[i]-k)){
                res+=map.get(prefix[i]-k);
            }
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        return res;
    }
}