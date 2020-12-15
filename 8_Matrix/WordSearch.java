/*
Share
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or 
vertically neighboring. The same letter cell may not be used more than once.
*/
class Solution {
    Boolean visited[][];
    public boolean exist(char[][] board, String word) {
        boolean visited[][] =new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,visited,i,j,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    boolean dfs(char[][] board,boolean visited[][],int x,int y,String word,int index){
        if(index==word.length()-1) return true;
        visited[x][y]=true;
        int[] xx={0,0,1,-1};
        int[] yy={1,-1,0,0};
        for(int i=0;i<xx.length;++i){
            if(!isSafe(board,visited,x+xx[i],y+yy[i],word,index+1)) continue;
            if(dfs(board,visited,x+xx[i],y+yy[i],word,index+1)){
                return true;
            }
        }
        visited[x][y]=false;
        return false;
    }
    
    boolean isSafe(char[][] board,boolean visited[][], int x, int y,String word,int index){
        return x>=0 && x<board.length && y>=0 && y<board[0].length && !visited[x][y] && 
            board[x][y]==word.charAt(index);
    }
}

class Solution {
    Boolean visited[][];
    public boolean exist(char[][] board, String word) {
       visited=new Boolean[board.length][board[0].length]; 
       for(int i=0;i<board.length;++i){
           for(int j=0;j<board[0].length;++j){
               if(word.charAt(0)!=board[i][j]) continue;
               visited[i][j]=true;
               if(helper(board,word,i,j,""))  return true;
               visited[i][j]=null;
           }
       } 
       return false; 
    }
    
    Boolean helper(char[][] board, String word,int i,int j,String s){
        if(!word.contains(s+board[i][j])) return false;
        if(word.equals(s+board[i][j])) return true;
        int []x={0,0,-1,1};
        int []y={1,-1,0,0};
        for(int m=0;m<x.length;++m){
            if(!(i+x[m]<0 || j+y[m]<0 || i+x[m]>=board.length || j+y[m]>=board[0].length 
						|| visited[i+x[m]][j+y[m]]!=null)){
                visited[i+x[m]][j+y[m]]=true;
                if(helper(board,word,i+x[m],j+y[m],s+board[i][j])) return true;
                visited[i+x[m]][j+y[m]]=null; 
            } 
        }
        return false;
    }
}