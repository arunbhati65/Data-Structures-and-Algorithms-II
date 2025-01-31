//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int[][] memo=new int[matrix.length+1][matrix[0].length+1];
        int squareSize=0;
        for(int i=1;i<memo.length;++i){
            for(int j=1;j<memo[0].length;++j){
                if(matrix[i-1][j-1]=='1'){
                    memo[i][j]=Math.min(Math.min(memo[i-1][j-1],memo[i-1][j]),memo[i][j-1])+1;
                    squareSize=Math.max(squareSize,memo[i][j]);
                }
            }
        }
        return squareSize*squareSize;
    }
}