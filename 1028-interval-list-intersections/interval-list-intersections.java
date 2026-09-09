class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n1=firstList.length, n2=secondList.length;
        int i=0,j=0;
        List<int[]>res=new ArrayList<>();
        while(i<n1 && j<n2){
            int start=Math.max(firstList[i][0],secondList[j][0]);
            int end=Math.min(firstList[i][1],secondList[j][1]);
            if(start<=end)
                res.add(new int[]{start,end});
            if(firstList[i][1]<secondList[j][1])
                i++;
            else{
                j++;
            }

        }
        return res.toArray(new int[res.size()][]);
    }
}