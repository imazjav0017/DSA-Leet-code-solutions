class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int src=image[sr][sc];
        int rows=image.length,cols=image[0].length;
        if(src==color)
            return image;
        Queue<int[]>queue=new ArrayDeque<>();
        image[sr][sc]=color;
        queue.offer(new int[]{sr,sc});
        while(!queue.isEmpty()){
            int[]x=queue.poll();
            int r=x[0],c=x[1];
            int top[]={r-1,c},bottom[]={r+1,c},left[]={r,c-1},right[]={r,c+1};
            int directions[][]={top,bottom,left,right};
            for(int[]dir:directions){
                int dr=dir[0],dc=dir[1];
                if(dr>=0 && dr<rows && dc>=0 && dc<cols && image[dr][dc]==src){
                    queue.offer(dir);
                    image[dr][dc]=color;
                }
            }
        }
        return image;
    }
}