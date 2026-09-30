class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m=nums1.length,n=nums2.length;
    if(m>n){
        return findMedianSortedArrays(nums2,nums1);
    }
    int left=0,right=m;
    int half=(m+n+1)/2;
    while(left<=right){
        int partitionA=left+(right-left)/2;
        int partitionB=half-partitionA;
        int aLeft=partitionA==0?Integer.MIN_VALUE:nums1[partitionA-1];
        int aRight=partitionA==m?Integer.MAX_VALUE:nums1[partitionA];
        int bLeft=partitionB==0?Integer.MIN_VALUE:nums2[partitionB-1];
        int bRight=partitionB==n?Integer.MAX_VALUE:nums2[partitionB];
        if(aLeft<=bRight && bLeft<=aRight){
            if((m+n)%2==1){
                return Math.max(aLeft,bLeft);
            }
            else{
                return (Math.max(aLeft,bLeft)+Math.min(aRight,bRight))/2.0;
            }
        }
        else if(aLeft>bRight){
            right=partitionA-1;
        }
        else{
            left=partitionA+1;
        }

    }
    return 0;
    }
}