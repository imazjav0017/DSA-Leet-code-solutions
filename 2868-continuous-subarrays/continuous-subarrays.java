class Solution {
    public long continuousSubarrays(int[] nums) {
        int n=nums.length;
        Deque<Integer>max=new ArrayDeque<>();
        Deque<Integer>min=new ArrayDeque<>();
        int left=0,right=0;
        long total=0;
        while(right<n){
            int num=nums[right];
            while(!max.isEmpty() && max.peekLast()<num){
                max.pollLast();
            }
            max.offerLast(num);
            while(!min.isEmpty() && min.peekLast()>num){
                min.pollLast();
            }
            min.offerLast(num);
            while(max.peekFirst()-min.peekFirst()>2){
                if(max.peekFirst()==nums[left]){
                    max.pollFirst();
                }
                if(min.peekFirst()==nums[left]){
                    min.pollFirst();
                }
                left++;
            }
            long len=(long)right-left+1;
            long sum=(len*(len+1))/2;
            long prevSum=((len-1) * len)/2;
            total+=sum-prevSum;
            right++;
        }
        return total;
    }
}