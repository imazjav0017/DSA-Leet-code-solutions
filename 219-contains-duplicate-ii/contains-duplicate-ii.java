class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        if(n==1 ||k==0) return false;
        Map<Integer,Integer>map=new HashMap<>();
        for(int x=0;x<=k && x<n;x++){
            int c=map.getOrDefault(nums[x],0);
            if(c==1)
                return true;
            map.put(nums[x],c+1);
        }
        if(k>=n) return false;
        int i=1,j=i+k;
        while(j<n){
         map.put(nums[i-1],0);
         int c=map.getOrDefault(nums[j],0);
         if(c==1)
            return true;
        map.put(nums[j],c+1);
        i++;
        j++;   
        }
        return false;
    }
}