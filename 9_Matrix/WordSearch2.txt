/*
Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally 
or vertically neighboring. The same letter cell may not be used more than once in a word.
*/
class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans=new ArrayList<>();
        if(words.length==0) return ans;
        for(String word:words){
            if(exist(board,word)){
                ans.add(word);
            }
        }
        return ans;
    }
    Boolean visited[][];
    private boolean exist(char[][] board, String word) {
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
    Boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list=new LinkedList<>();
        for(int i=0;i<words.length;++i){
            if(wordSearch(board,words[i].toCharArray())){
                list.add(words[i]);
            }
        }
        return list;
    }
    
    Boolean wordSearch(char[][] board, char[] words){
        visited=new Boolean[board.length][board[0].length];
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(visited[i][j]==null && words[0]==board[i][j]){
                    visited[i][j]=true;
                    if(DFS(board,i,j,words,0)){return true;}
                    visited[i][j]=null;                    
                }
            }
        }
        return false;
    }
    
    Boolean DFS(char[][] board,int i,int j,char[] words,int n){
        int[] x={0,0,-1,1};
        int[] y={1,-1,0,0};
        if(n==words.length-1) return true;
        for(int m=0;m<x.length;++m){
            if(isSafe(board,i+x[m],j+y[m],words,n+1)){
                visited[i+x[m]][j+y[m]]=true;
                if(DFS(board,i+x[m],j+y[m],words,n+1)){return true;}
                visited[i+x[m]][j+y[m]]=null;
            }
        }
        return false;
    }
    
    Boolean isSafe(char[][] board,int i,int j,char[] words,int n){
        return (i>=0 && i<board.length && j>=0 && j<board[0].length && visited[i][j]==null 
                && n<words.length && words[n]==board[i][j]);
    }
    
}