class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode fast=head;
        ListNode half=head;
        ListNode tail=half;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            tail=half;
            half=half.next;
        }
        tail.next=null;
        ListNode left= sortList(head);
        ListNode right= sortList(half);
        return merge(left,right);
    }
    
    ListNode merge(ListNode left, ListNode right){
        ListNode dummy=new ListNode();
        ListNode current=dummy;
        while(left!=null && right!=null){
            if(left.val>=right.val){
                current.next=right;
                right=right.next;
                current=current.next;
            }else{
                current.next=left;
                left=left.next;
                current=current.next;
            }
        }
        if(left!=null){current.next=left;}
        if(right!=null){current.next=right;}
        return dummy.next;
    }
}