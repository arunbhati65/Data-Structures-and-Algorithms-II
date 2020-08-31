class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode current=head,next;
        head=head.next;
        ListNode prev=null;
        while(current!=null && current.next!=null){
            current = reverse(current,prev);
            prev=current.next;
            current=current.next.next;
        }
        return head;
    }
    
    ListNode reverse(ListNode current,ListNode prev){
        ListNode temp=current.next; 
        current.next=temp.next;
        temp.next=current;
        if(prev!=null)prev.next=temp;
        return temp;
    }
}