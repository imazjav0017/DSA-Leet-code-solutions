class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>set=new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }
        Set<Integer>res=new HashSet<>();
        for(int i:nums2){
            if(set.contains(i)){
                res.add(i);
            }
        }
        int[]ans=new int[res.size()];
        int i=0;
        for(int k:res){
            ans[i++]=k;
        }
        return ans;
    }
}