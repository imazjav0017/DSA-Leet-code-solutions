class Solution {
    boolean canDo(int[]p,int mid,int m){
        int b=1;
        int last=p[0];
        for(int i=1;i<p.length;i++){
            if(p[i]-last>=mid){
                b++;
                last=p[i];
                if(b>=m)
                    return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left=1,right=position[position.length-1]-position[0]+1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(!canDo(position,mid,m))
                right=mid;
            else left=mid+1;
        }
        return left-1;
    }
}