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
        Queue<Integer> q1=new LinkedList<>(),q2=new LinkedList<>();
        while(l1!=null){
            q1.add(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            q2.add(l2.val);
            l2=l2.next;
        }
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        int carry=0;
        while(!q1.isEmpty() || !q2.isEmpty() || carry!=0){
            int x=q1.isEmpty()?0:q1.poll();
            int y=q2.isEmpty()?0:q2.poll();
            int sum=(x+y+carry)%10;
            carry=(x+y+carry)/10;
            temp.next=new ListNode(sum);
            temp=temp.next;
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        int carry=0;
        while(l1!=null && l2!=null){
            int sum=carry+l1.val+l2.val;
            carry=0;
            curr.next=new ListNode(sum%10);
            carry=sum/10;
            l1=l1.next;
            l2=l2.next;
            curr=curr.next;
        }
        
        while(l1!=null){
            int sum=carry+l1.val;
            carry=0;
            curr.next=new ListNode(sum%10);
            carry=sum/10;
            l1=l1.next;
            curr=curr.next;
        }
        
        while(l2!=null){
            int sum=carry+l2.val;
            carry=0;
            curr.next=new ListNode(sum%10);
            carry=sum/10;
            l2=l2.next; 
            curr=curr.next;
        }
        
        if(carry!=0){
            curr.next=new ListNode(carry);
        }
        
        return dummy.next;
    }
}
