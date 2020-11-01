/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
class Node {
    Integer val; 
    Node next; 
    public Node(){} 
    public Node(Integer val){this.val=val;}
}

class MinStack {
    int size=0;
    Node top1=new Node(); 
    Node top2=new Node(Integer.MAX_VALUE); 

    public MinStack() {
        
    }
    
    public void push(int x) {
        Node newNode=new Node(x);
        newNode.next=top1; top1=newNode;
        Node newMinNode=new Node(Math.min(x,top2.val));
        newMinNode.next=top2; top2=newMinNode;
        ++size;
    }
    
    public void pop() {
        top1=top1.next; top2=top2.next; --size;
    }
    
    public int top() {
        return top1.val;
    }
    
    public int getMin() {
        return top2.val;
    }
}
