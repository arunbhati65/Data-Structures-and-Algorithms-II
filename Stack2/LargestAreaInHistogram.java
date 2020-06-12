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
//*********************************8
class Solution {   //Revised One
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s=new Stack<>();
        s.push(-1);
        int maxArea=0;
        for(int i=0;i<heights.length;++i){
            while(s.peek()!=-1 && heights[s.peek()]>=heights[i]){// 1 2 3 4 for decreasing 3
                maxArea=Math.max(maxArea,heights[s.pop()]*(i-(s.peek()+1))); // calculate for (4<-)  , (4 & 3<-) , (2<-,3,4)   (1<-,2,3,4)
            }
            s.push(i);
        }
        while(s.peek()!=-1){ // for increasing 1 2 3 4 5 6 7
            maxArea=Math.max(maxArea,heights[s.pop()]*(heights.length-(s.peek()+1)));
        }
        return maxArea;
        
    }
}