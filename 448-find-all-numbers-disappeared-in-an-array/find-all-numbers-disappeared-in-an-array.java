class Solution {
    /*
    [4,3,2,7,8,2,3,1]
    i=0->idx=4, a[3]=-1-> [4,3,2,-1,8,2,3,1]
    i=1-> idx=3, a[2]=-1-> [4,3,-1,-1,8,2,3,1]
    i=2-> idx=-1
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>res=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){ //[4,3,2,]
           int idx=nums[i];
           nums[Math.abs(idx)-1]=-(Math.abs(nums[Math.abs(idx)-1]));
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0)
                res.add(i+1);
        }
        return res;
    }
}