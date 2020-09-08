/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
       return l1; 
    }
}