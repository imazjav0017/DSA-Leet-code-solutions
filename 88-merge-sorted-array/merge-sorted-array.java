class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            for (int i = 0; i < n; i++) {
            nums1[i] = nums2[i]; 
            }
        }
        else if(n!=0)
        {
          int res[]=new int[m+n];
          int p1=0;
          int p2=0;
          int filled=0;
          for (;(p1<m && p2<n);filled++){
            if(nums1[p1]<nums2[p2]){
                res[filled]=nums1[p1];
                p1++;
            }
            else
            {
                res[filled]=nums2[p2];
                p2++;
            }
          }
          if(p1<m){
            int i=filled;
            while(p1<m){
                res[i]=nums1[p1];
                p1++;
                i++;
            }
          }
          else if(p2<n){
            int i=filled;
            while(p2<n){
                res[i]=nums2[p2];
                p2++;
                i++;
            }
          }
          for (int i=0;i<m+n;i++){
            nums1[i]=res[i];
          }
        }
    }
}