/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);
        int carry=0,sum;
        ListNode current1=l1,current2=l2,prev1=null,prev2=null;
        while(current1 !=null && current2 !=null){
            sum=current1.val+current2.val+carry;
            carry=sum/10;
            current1.val=sum%10;
            prev1=current1; prev2=current2;
            current1=current1.next; current2=current2.next;
        }
        while(current1!=null){
            sum= current1.val+carry;
            current1.val=sum%10;
            carry=sum/10;
            prev1=current1;
            current1=current1.next;
        }
        while(current2!=null){
            sum= current2.val+carry;
            prev1.next=new ListNode(sum%10);
            carry=sum/10;
            prev1=prev1.next;
            current2=current2.next;
        }
        if(carry!=0){
            prev1.next=new ListNode(carry);
        }
       return reverse(l1); 
    }
    
    ListNode reverse(ListNode head){
        ListNode prev=null,next=null,curr=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}