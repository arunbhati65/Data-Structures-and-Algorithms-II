/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=getStack(l1);
        Stack<Integer> s2=getStack(l2);
        ListNode dummy=new ListNode();
        int carry=0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int x=s1.isEmpty()?0:s1.pop();int y=s2.isEmpty()?0:s2.pop();
            int sum=(x+y+carry)%10;
            carry=(x+y+carry)/10;
            addAfterDummyNode(new ListNode(sum), dummy);
        }
        if(carry!=0){
            addAfterDummyNode(new ListNode(carry), dummy);
        }
        return dummy.next;
    }
    
    void addAfterDummyNode(ListNode node,ListNode dummy){
        node.next=dummy.next;
        dummy.next=node;
    }
    
    Stack getStack(ListNode node){
        Stack<Integer> stack=new Stack<>();
        while(node !=null){
            stack.add(node.val);
            node=node.next;
        }
        return stack;
    }
        
}