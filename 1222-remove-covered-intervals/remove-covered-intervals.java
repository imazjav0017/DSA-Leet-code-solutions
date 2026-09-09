class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0])
               return Integer.compare(a[0],b[0]);
            return Integer.compare(b[1],a[1]);
        });
        int maxEnd=-1;
        int count=0;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]>maxEnd){
              count++;
               maxEnd=intervals[i][1];
            }
        }
        return count;

    }
}