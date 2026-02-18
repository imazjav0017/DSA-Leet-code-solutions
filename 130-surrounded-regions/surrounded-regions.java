class Solution {
    private void dfs(int r,int c,char[][]board,boolean[][] visited){
        if(r<0||c<0 ||r>=board.length||c>=board[0].length || board[r][c]=='X'|| visited[r][c])
            return;
        visited[r][c]=true;
        dfs(r-1,c,board,visited);
        dfs(r+1,c,board,visited);
        dfs(r,c+1,board,visited);
        dfs(r,c-1,board,visited);
    }
    public void solve(char[][] board) {
        int m=board.length,n=board[0].length;
        boolean[][]visited=new boolean[m][n];
        for(int j=0;j<n;j++){
            if(board[0][j]=='O' && !visited[0][j])
                dfs(0,j,board,visited);
        }
        for(int j=0;j<n;j++){
            if(board[m-1][j]=='O' && !visited[m-1][j])
                dfs(m-1,j,board,visited);
        }
        for(int j=0;j<m;j++){
            if(board[j][0]=='O' && !visited[j][0])
                dfs(j,0,board,visited);
        }
        for(int j=0;j<m;j++){
            if(board[j][n-1]=='O' && !visited[j][n-1])
                dfs(j,n-1,board,visited);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
}