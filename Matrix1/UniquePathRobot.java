/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
*/
class Solution {
    Integer memo[][];
    public int uniquePathsWithObstacles(int[][] arr) {
        memo=new Integer[arr.length+1][arr[0].length+1];
        return helper(arr,0,0);
    }
    
    int helper(int[][] arr,int i,int j){
        if(arr[i][j]==1){ return 0;} 
        else if(i==arr.length-1 && j==arr[0].length-1) {return 1;}
        else if (memo[i][j]!=null) return memo[i][j];
        int way=0;
        if(i+1<arr.length){
            way=way+helper(arr,i+1,j);
        }
        if(j+1<arr[0].length){
            way=way+helper(arr,i,j+1);     
        }
        memo[i][j]=way;
        return memo[i][j];
        
    }
}