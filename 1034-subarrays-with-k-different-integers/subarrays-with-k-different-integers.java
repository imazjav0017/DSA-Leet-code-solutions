class Solution {
    int atMost(int[]nums,int n,int k){
        int left=0;
        int right=0;
        Map<Integer,Integer>map=new HashMap<>();
        int ans=0;
        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                if(map.get(nums[left])==0)
                    map.remove(nums[left]);
                left++;
            }
            ans+=right-left+1;
            right++;
        }
        return ans;

    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n=nums.length;
        return atMost(nums,n,k)-atMost(nums,n,k-1);
    }
}