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


class Solution {//Faulty
    public int largestRectangleArea(int[] arr) {
        if(arr.length==0) return 0;
        int largestArea=arr[0]*1;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<arr.length;++i){
                while(!stack.isEmpty()&&arr[i]<=arr[stack.peek()]){
                    int pop=stack.pop();
                    int area=stack.isEmpty()?arr[pop]*(i-0):arr[pop]*(i-pop);
                    largestArea=Math.max(largestArea,area);
                }
            stack.push(i);
        }
        while(!stack.isEmpty()){
           int pop=stack.pop();
           int area=stack.isEmpty()?arr[pop]*(arr.length-0):arr[pop]*(arr.length-pop);
           largestArea=Math.max(largestArea,area);
        }
        return largestArea;
    }
}

