class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n=dimensions.length;
        double[]diagonals=new double[n];
        for(int i=0;i<n;i++){
            int a= dimensions[i][0], b=dimensions[i][1];
            double d=Math.sqrt((a*a + b*b));
            diagonals[i]=d;
        }
        List<Integer>max=new ArrayList<>();
        double maxD=0;
        for(int i=0;i<n;i++){
            if(diagonals[i]>maxD)
                {
                    maxD=diagonals[i];
                    max.clear();
                    max.add(i);
                }
            else if(diagonals[i]==maxD){
                max.add(i);
            }  
        }
    // System.out.println(max);
    int maxArea=0;
    for(int i=0;i<max.size();i++){
        int area = dimensions[max.get(i)][0]*dimensions[max.get(i)][1];
        if(area>maxArea)maxArea=area;
    }
        return maxArea;
    }
}