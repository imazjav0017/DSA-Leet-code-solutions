class Solution {
    int[][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
    void dfs(char[][]board,int row, int col, int m, int n,boolean[][]visited){
        visited[row][col]=true;
        for(int[]d:dirs){
            int nr=row+d[0];
            int nc=col+d[1];
            if(nr<0||nr>=m||nc<0||nc>=n)
                continue;
            if(visited[nr][nc] || board[nr][nc]=='X')
                continue;
            dfs(board,nr,nc,m,n,visited);
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][]safe=new boolean[m][n];
        for(int i=0;i<m;i++){
            if(!safe[i][0] && board[i][0]=='O')
                dfs(board,i,0,m,n,safe);
            if(!safe[i][n-1] && board[i][n-1]=='O')
                dfs(board,i,n-1,m,n,safe);
        }
        for(int j=0;j<n;j++){
            //System.out.println("CH:"+board[m-1][j]+","+String.valueOf(board[m-1][j]=='O'));
            if(!safe[0][j] && board[0][j]=='O')
                dfs(board,0,j,m,n,safe);
            if(!safe[m-1][j] && board[m-1][j]=='O')
                dfs(board,m-1,j,m,n,safe);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && !safe[i][j])
                    board[i][j]='X';
            }
        }
    }
}