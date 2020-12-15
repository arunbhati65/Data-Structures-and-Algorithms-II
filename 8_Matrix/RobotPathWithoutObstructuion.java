/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/
class Solution {
    Integer memo[][];
    public int uniquePaths(int m, int n) {
        memo=new Integer[m][n];
        return helper(m,n,0,0);
    }
    
    int helper(int m,int n,int i,int j){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(memo[i][j]!=null) return memo[i][j];
        int possibleWays=0;
        possibleWays=possibleWays+helper(m,n,i+1,j)+helper(m,n,i,j+1);
        return memo[i][j]=possibleWays;
    }
}