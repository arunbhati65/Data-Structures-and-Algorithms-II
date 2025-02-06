/*
Given a linked list, remove the n-th node from the end of list and return its head.
 */
class RemoveNthFromEnd{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode pointer1=dummy;
        ListNode pointer2=dummy;
        
        for(int i = 1;i<=n+1;++i){
            pointer1=pointer1.next;
        }
        while(pointer1!=null){
            pointer1=pointer1.next;
            pointer2=pointer2.next;
        }
        pointer2.next=pointer2.next.next;
        return dummy.next;
    }
}