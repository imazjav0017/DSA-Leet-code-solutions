class Solution {
    public void bfs(int [][] isConnected , int src, boolean[] isVisited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        isVisited[src] = true;
        
        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i = 0; i < isConnected.length; i++){
                if(isConnected[current][i] == 1 && !isVisited[i]){
                    queue.offer(i);
                    isVisited[i] = true;
                }
            }
        }
    }
    

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int Provinces = 0;

        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                Provinces++;              
                bfs(isConnected, i, isVisited);
            }
        }
        return Provinces;
    }
}