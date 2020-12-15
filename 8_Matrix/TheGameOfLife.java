/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
*/
class Solution {
    Boolean visited[][];
    int x[]={0,0,1,-1,-1,1,1,-1};
    int y[]={1,-1,0,0,1,-1,1,-1};
    public void gameOfLife(int[][] board) {
        visited=new Boolean[board.length][board[0].length];
        helper(board);
        restoreUpdateValues(board);
    }
    
    void restoreUpdateValues(int[][] board){
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(board[i][j]==-1){board[i][j]=0;}
                if(board[i][j]==2){board[i][j]=1;}
            }
        }        
    }
    
    void helper(int[][] board){
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(visited[i][j]==null){
                    DFS(board,i,j);      
                }
            }
        }
    }
    
    void DFS(int[][] board,int i,int j){
        visited[i][j]=true;
        int count=sourroundingOneCount(board,i,j);
        if(board[i][j]==1&&count<2){
            board[i][j]=-1;
        }else if(board[i][j]==1&&(count==2 || count==3)){
            board[i][j]=board[i][j];
        }else if(board[i][j]==1 && count>3){
            board[i][j]=-1;
        }else if(board[i][j]==0 && count==3){
            board[i][j]=2;
        }
        for(int m=0;m<x.length;++m){
            if(isSafe(board,i+x[m],j+y[m])){
                DFS(board,i+x[m],j+y[m]);
            }
        }
    }
    
    int sourroundingOneCount(int[][] board,int i,int j){
        int count=0;
        for(int m=0;m<x.length;++m){
            int currI=i+x[m]; int currJ=j+y[m];
            if(isSafeW(board,currI,currJ)){
                if(board[currI][currJ]==1 || board[currI][currJ]==-1) ++count;
            }
        }
        return count; 
    }
    
    boolean isSafeW(int[][] board,int i,int j){
        return (i>=0 && i<board.length) && (j>=0 && j<board[0].length);
    }
    boolean isSafe(int[][] board,int i,int j){
        return (i>=0 && i<board.length) && (j>=0 && j<board[0].length) && visited[i][j]==null;
    }
    
    
}