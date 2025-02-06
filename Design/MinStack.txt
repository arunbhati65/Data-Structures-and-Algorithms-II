class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    
    public MinStack() {
        stack.push(Integer.MAX_VALUE);
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        stack.push(x);
        if(stack.peek()!= Integer.MAX_VALUE && stack.peek()<=x){
            minStack.push(stack.peek());
        }else{
            minStack.push(x);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
