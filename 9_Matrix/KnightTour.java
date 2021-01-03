class Solution {
    boolean visited[][] = new boolean[8][8];
    public void knightTour(int[] nums, int target) {
        solveKT();
        for(int i=0;i<visited.length;++i){
            for(int j=0;j<visited[0].length;++j){
                if(visited[i][j]==false){
                    System.out.println("False");
                    return null;
                }
            }
        }
        System.out.println("True");
    }
    
    void solveKT(){
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		solveKTUtil(0, 0, xMove, yMove);
	}
    
	boolean isSafe(int x, int y)
	{
		return (x >= 0 && x < visited.length && y >= 0 && y < visited[0].length	&& visited[x][y] == false);
	}


	void solveKTUtil(int x, int y, int xMove[],int yMove[]){
		visited[x][y] = true;
        for (int k = 0; k < 8; k++) {
			int next_x = x + xMove[k];
			int next_y = y + yMove[k];
			if (isSafe(next_x, next_y)) {
				solveKTUtil(next_x, next_y, xMove, yMove);
			}
		}
	}
}