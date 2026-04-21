class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int diff=-1;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                int nd=Math.abs((sum-target));
                if(nd<diff||diff==-1)
                    {
                        diff=nd;
                        res=nums[i]+nums[j]+nums[k];
                        if(res==target)break;
                    }
                if(sum-target<0){
                    j++;
                }
                else if(sum-target>0){
                    k--;
                }
            }
            if(res==target)
                break;
        }
        return res;
    }
}