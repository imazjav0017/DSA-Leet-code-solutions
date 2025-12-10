class Solution {
    /*
    [-1,0,1,2,-1,-4]
    sort-> [-4, -1,-1,-1,0,1,2]
    for i=0 to n-2
        if(i>0)break;
        if(i!=-0 and i=i-1)continue;
        left =i+1 right =n-1
        while(left<right)
            sum= i+left+right
            if(sum==0) add to list, left++ right -- 
                while(left-1==left)left++
                while(right+1==right)right--
            elif sum<0 left++
            else right--;
     */
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>>res=new ArrayList<>();
       int n=nums.length;
       Arrays.sort(nums);
       for(int i=0;i<n-2;i++){
        if(i!=0 && nums[i]==nums[i-1])
            continue;
        if(nums[i]>0) break;
        int left=i+1;
        int right=n-1;
        while(left<right){
            int sum=nums[i]+nums[left]+nums[right];
            if(sum==0){
                res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;
                right--;
                while(left<right && nums[left-1]==nums[left])left++;
                while(left<right && nums[right+1]==nums[right])right--;
            }
            else if(sum<0){
                left++;
            }
            else right--;
        }
       }
       return res;
    }
}