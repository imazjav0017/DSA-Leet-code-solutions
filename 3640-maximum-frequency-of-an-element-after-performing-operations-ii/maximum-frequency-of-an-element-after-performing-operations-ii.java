class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
    int n=nums.length;
    Arrays.sort(nums);
    Map<Integer,Integer>freqMap=new HashMap<>();
    for(int i:nums){
        freqMap.put(i,freqMap.getOrDefault(i,0)+1);
    }
    int left=0;
    int right=0;
    int ans=0;
    //target is in array
    for(int i=0;i<n;i++){
        int target=nums[i];
        while(left<n && nums[left]<target-k){
            left++;
        }
        while(right<n && nums[right]<=target+k){
            right++;
        }
        int reachable=right-left;
        int alreadyEqual=freqMap.get(target);
        int canChange=reachable-alreadyEqual;
        ans=Math.max(ans,alreadyEqual+Math.min(numOperations,canChange));
    }
    //target is not in array
    left=0;
    for(right=0;right<n;right++){
        while(nums[right]-nums[left]>2*k){
            left++;
        }
        int win=right-left+1;
        ans=Math.max(ans,Math.min(numOperations,win));
    }
    return ans;
}
}