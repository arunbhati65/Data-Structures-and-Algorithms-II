class Solution {
    //prev curr
    //null //1   2 3 4 5
    public ListNode reverseList(ListNode head) {
        ListNode prev=null,curr=head,next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}