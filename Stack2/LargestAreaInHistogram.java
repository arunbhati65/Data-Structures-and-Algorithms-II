/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.
*/
class Solution {
    Stack<Integer> stack=new Stack<Integer>();
    int maxArea=0;
    public int largestRectangleArea(int[] heights) {
        stack.push(-1);
        for(int i=0;i<heights.length;++i){
            while(stack.peek()!=-1 && heights[stack.peek()]>=heights[i]){
                maxArea=Math.max(maxArea,heights[stack.pop()]*(i-(stack.peek()+1)));
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            maxArea=Math.max(maxArea,heights[stack.pop()]*(heights.length-(stack.peek()+1)));
        }
        return maxArea;
    }
}