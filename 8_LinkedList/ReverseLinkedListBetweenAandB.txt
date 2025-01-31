class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        int i=0;
        while(head!=null && m>1){
            m--;
            n--;
            prev=head;
            head=head.next;
        }
        prev.next=reverse(head,n);
        return dummy.next;
    }
    
    ListNode reverse(ListNode head,int n){
        if(head==null) return null;
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode next=null,prev=null,curr=head;
        while(curr!=null && n>0){
            --n;
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head.next=curr;
        return prev;
    }
}