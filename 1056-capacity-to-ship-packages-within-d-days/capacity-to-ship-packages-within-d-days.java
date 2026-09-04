class Solution {
   boolean canDo(int[] weights, int capacity, int limit) {

    int days = 1;
    int currentWeight = 0;

    for (int weight : weights) {

        if (currentWeight + weight > capacity) {
            days++;
            currentWeight = 0;
        }

        currentWeight += weight;

        if (days > limit)
            return false;
    }

    return true;
}
    public int shipWithinDays(int[] weights, int days) {
        int max=weights[0];
        int sum=0;
        for(int i=0;i<weights.length;i++){
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        int left=max,right=sum;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canDo(weights,mid,days))
                right=mid;
            else left=mid+1;
        }
        return left;
    }
}