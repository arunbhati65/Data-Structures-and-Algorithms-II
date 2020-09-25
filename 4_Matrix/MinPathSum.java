class Solution {
    Integer[][] memo;
    public int minPathSum(int[][] grid) {
        memo=new Integer[grid.length][grid[0].length];
        return helper(grid,0,0);
    }
    
    int helper(int[][] grid,int i, int j){
        if(i==grid.length || j==grid[0].length) return Integer.MAX_VALUE;
        if(memo[i][j]!=null) return memo[i][j];
        if(i==grid.length-1 && j==grid[0].length-1) return memo[i][j]=grid[i][j];
        int down=helper(grid,i+1,j);
        int right=helper(grid,i,j+1);
        return memo[i][j]=grid[i][j]+Math.min(down,right);
    }
}
