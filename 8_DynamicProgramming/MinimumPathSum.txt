/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
*/
class Solution {
    Integer[][] memo;
    public int minPathSum(int[][] grid) {
        memo=new Integer[grid.length+1][grid[0].length+1];
        if(grid.length==0) return 0;
        return helper(grid,0,0);
    }
    
    int helper(int[][] grid,int i,int j){
        if(memo[i][j]!=null) return memo[i][j];
        if(i==grid.length || j==grid[0].length) return  memo[i][j]= Integer.MAX_VALUE;
        if(i==grid.length-1 && j==grid[0].length-1) {
            return memo[i][j]=grid[i][j]; 
        }   
        return  memo[i][j]=grid[i][j]+Math.min(helper(grid,i+1,j),helper(grid,i,j+1));
    }
}