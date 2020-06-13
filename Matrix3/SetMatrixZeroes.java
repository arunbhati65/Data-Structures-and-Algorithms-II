//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[0].length;++j){
                if(matrix[i][j]==0){
                    Line(matrix,i,j);
                }
            }
        }
        
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[0].length;++j){
                if(matrix[i][j]==-1000000){
                    matrix[i][j]=0;
                }
            }
        }
    }
    
    void Line(int[][] matrix,int i,int j){
        for(int m=0;m<matrix.length;++m){
            if(m!=i && matrix[m][j]!=0){
                matrix[m][j]=-1000000;
            }
        }
        for(int m=0;m<matrix[0].length;++m){
            if(m!=j && matrix[i][m]!=0){
                matrix[i][m]=-1000000;
            }
        }
    }
}