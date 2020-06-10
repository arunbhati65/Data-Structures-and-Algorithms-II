class StockSpanner {
    Stack<Integer> stack=new Stack<>();
    HashMap<Integer,Integer> map=new HashMap<>();
    int index=-1;
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        ++index;map.put(index,price);
        int span=1;
        if(index!=0){
            while(!stack.isEmpty() && map.get(stack.peek())<=price){
                stack.pop();
            }
            span=stack.isEmpty()?index+1:index-stack.peek();
        }
        stack.push(index);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */