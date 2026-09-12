class Solution {
    public int maximumPopulation(int[][] logs) {
        int[]diff=new int[101];
        for(int[]log:logs){
            int b=log[0],d=log[1];
            diff[b-1950]++;
            diff[d-1950]--;
        }
        int maxYear=2050;
        int maxCount=0;
        for(int i=0;i<101;i++){
            if(i!=0)
                diff[i]=diff[i]+diff[i-1];
            
            if(diff[i]>maxCount){
                maxCount=diff[i];
                maxYear=i+1950;
            }
        }
        return maxYear;
    }
}