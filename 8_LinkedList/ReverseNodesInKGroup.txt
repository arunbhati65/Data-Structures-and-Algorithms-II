/**
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes 
is not a multiple of k then left-out nodes in the end should remain as it is.
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        int size=0;
        while(curr!=null){
            curr=curr.next;
            ++size;
        }
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode last=dummy;
        int i=0;
        while(last!=null && size-i>=k){
            last=reverseKElementsOnly(last,k);
            i=i+k;
        }
        return dummy.next;
        
    }
    
    ListNode reverseKElementsOnly(ListNode last,int k){
        int i=0;
        ListNode head=last.next;
        ListNode curr=head,prev=null,next=null;
        while(i<k && curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            ++i;
        }
        last.next=prev;//prev have become head nad will be attached to last 
        if(head!=null){
            head.next=curr;    
        }
        return head;//head have come to end and will become last for next call
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head,prevTail=null,newHead=null;
        while(curr!=null){
            int count=0;
            curr=head;
            while(count<k && curr!=null){
                curr=curr.next;
                ++count;
            }
            if(count==k){
                ListNode revHead=reversekNodes(head,k);
                if(prevTail!=null){prevTail.next=revHead;}
                if(newHead==null){newHead=revHead;}
                prevTail=head;
                head=curr;
            }
        }
        if(prevTail!=null){prevTail.next=head;}
        return newHead==null?head:newHead;
    }
    
    ListNode reversekNodes(ListNode node,int k){
        ListNode curr=node,prev=null,next=null;
        while(k>0){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            --k;
        }
        return prev;
    }
}