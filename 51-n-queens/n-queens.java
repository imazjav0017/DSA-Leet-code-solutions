class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][]board=new char[n][n];
        for(char[]row:board){
            Arrays.fill(row,'.');
        }
        Set<Integer>cols=new HashSet<>();
        Set<Integer>diag1=new HashSet<>();
        Set<Integer>diag2=new HashSet<>();
        backtrack(0,board,n,cols,diag1,diag2);
        return res;
    }
    void backtrack(int row, char[][]board,int n, Set<Integer>cols, Set<Integer>diag1, Set<Integer>diag2){
        if(row==n){
            List<String>solution=new ArrayList<>();
            for(char[]b:board){
                solution.add(new String(b));
            }
            res.add(solution);
            return;
        }
        for(int col=0;col<n;col++){
            if(cols.contains(col) || diag1.contains(row-col) || diag2.contains(row+col))
                continue;
            board[row][col]='Q';
            cols.add(col);
            diag1.add(row-col);
            diag2.add(row+col);
            backtrack(row+1,board,n,cols,diag1,diag2);
            board[row][col]='.';
            cols.remove(col);
            diag1.remove(row-col);
            diag2.remove(row+col);
        }
    }
}