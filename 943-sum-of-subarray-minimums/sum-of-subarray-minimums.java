class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long res=0;
        long MOD=(long)Math.pow(10,9)+7;
        Deque<Integer>stack=new ArrayDeque<>();
        for(int i=0;i<=n;i++){
            int value=i==n?Integer.MIN_VALUE:arr[i];
            while(!stack.isEmpty() && value<arr[stack.peek()]){
                int idx=stack.pop();
                int left=stack.isEmpty()?-1:stack.peek();
                int right=i;
                long leftChoices=(long)idx-left;
                long rightChoices=(long)right-idx;
                long contribution=arr[idx]*leftChoices*rightChoices;
                res=res+contribution;
                res=res%MOD;
            }
            if(i<n)
                stack.push(i);
        }
        return (int)res;
    }
}