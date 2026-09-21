class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[]dp=new int[n];
        int[]parent=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);
        int maxLength=1;
        int maxIndex=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<1+dp[j]){
                    dp[i]=1+dp[j];
                    parent[i]=j;
                }
            }
            if(dp[i]>maxLength){
                maxLength=dp[i];
                maxIndex=i;
            }
        }
        List<Integer>res=new ArrayList<>();
        while(maxIndex!=-1){
            res.add(nums[maxIndex]);
            maxIndex=parent[maxIndex];
        }
        Collections.reverse(res);
        return res;
    }
}