class Solution {
    /*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.
    */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean visited[][] =new boolean[image.length][image[0].length];
        dfs(image,visited,sr,sc,image[sr][sc],newColor);
        return image;
    }
    
    void dfs(int[][] image,boolean visited[][], int x, int y, int colorToReplace,int newColor){
        image[x][y]=newColor;
        visited[x][y]=true;
        int[] xx={0,0,1,-1};
        int[] yy={1,-1,0,0};
        for(int i=0;i<xx.length;++i){
            if(!isSafe(image,visited,x+xx[i],y+yy[i],colorToReplace)) continue;
            dfs(image,visited,x+xx[i],y+yy[i],colorToReplace,newColor);
        }
        visited[x][y]=false;
    }
    
    boolean isSafe(int[][] image,boolean visited[][], int x, int y, int colorToReplace){
        return x>=0 && x<image.length && y>=0 && y<image[0].length && !visited[x][y] && 
            image[x][y]==colorToReplace;
    }
}