class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start=intervals[0][0],end=intervals[0][1];
        List<List<Integer>>res=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }
            else{
                res.add(Arrays.asList(start,end));
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        res.add(Arrays.asList(start,end));
        int[][]arr=new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            List<Integer>interval=res.get(i);
            arr[i][0]=interval.get(0);
            arr[i][1]=interval.get(1);
        }
        return arr;
    }
}