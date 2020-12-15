class MyStack {
    Queue<Integer> topCarrier,restCarrier;
    public MyStack() {
        topCarrier=new LinkedList<>();
        restCarrier=new LinkedList<>();
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(topCarrier.isEmpty()){
            topCarrier.add(x);
        }else{
            while(!topCarrier.isEmpty()){
                restCarrier.add(topCarrier.poll());
            }
            topCarrier.add(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int top=topCarrier.poll();
        while(restCarrier.size()>=2){
            topCarrier.add(restCarrier.poll());
        }
        Queue<Integer> temp=topCarrier;
        topCarrier=restCarrier;
        restCarrier=temp;
        return top;
    }
    
    /** Get the top element. */
    public int top() {
        return topCarrier.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return topCarrier.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */