class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int prevStart=intervals[0][0],prevEnd=intervals[0][1];
        List<int[]>res=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=prevEnd){
                prevEnd=Math.max(prevEnd,intervals[i][1]);
            }
            else{
                res.add(new int[]{prevStart,prevEnd});
                prevStart=intervals[i][0];
                prevEnd=intervals[i][1];
            }
        }
        res.add(new int[]{prevStart,prevEnd});
        int[][]ans=new int[res.size()][2];
        int idx=0;
        for(int[]x:res){
            ans[idx][0]=x[0];
            ans[idx][1]=x[1];
            idx++;
        }
        return ans;
    }
}