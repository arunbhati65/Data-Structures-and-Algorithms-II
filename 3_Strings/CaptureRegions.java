/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
*/
class Pair{
    public int i;
    public int j;
    
    public Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public void solve(char[][] board) {
        if(board.length==0) return;
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<board.length;++i){
            list.add(new Pair(i,0));
            list.add(new Pair(i,board[0].length-1));
        }
        for(int i=0;i<board[0].length;++i){
            list.add(new Pair(0,i));
            list.add(new Pair(board.length-1,i));
        }
        for(Pair pair:list){
            DFS(board,pair.i,pair.j);
        }
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(board[i][j]=='O'){
                 board[i][j]='X';                    
                }else if(board[i][j]=='#'){
                 board[i][j]='O';
                }
            }
        }
    }
    
    void DFS(char[][] board,int i,int j){
        if(board[i][j]!='O') return;
        int []x={0,0,1,-1};
        int []y={1,-1,0,0};
        board[i][j]='#';
        for(int m=0;m<x.length;++m){
            if(isSafe(board,i+x[m],j+y[m])){
                DFS(board,i+x[m],j+y[m]);
            }
        }
    }
    
    boolean isSafe(char[][] board,int i,int j){
        return i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]=='O';
    }
}