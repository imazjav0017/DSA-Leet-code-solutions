class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        double left=0.0;
        double right=1.0;
        while(left<right){
            double mid=left+(right-left)/2.0;
            int count=0;
            int bestNum=0,bestDen=1;
            int j=1;
            for(int i=0;i<n-1;i++){
                if(j<=i)j=i+1;
                while(j<n && arr[i]>mid*arr[j])
                    j++;
                if(j==n)
                    break;
                count+=n-j;
                if((long)arr[i]*bestDen>(long)arr[j]*bestNum){
                    bestNum=arr[i];
                    bestDen=arr[j];
                }
            }
            if(count==k){
                return new int[]{bestNum,bestDen};
            }
            else if(count<k){
                left=mid;
            }
            else{
                right=mid;
            }
        }
        return new int[]{};
    }
}