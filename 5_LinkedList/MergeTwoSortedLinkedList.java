/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
 */
class Solution{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode[] lists={l1,l2};
        return mergeKLists(lists);
        
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy=new ListNode();
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode n1,ListNode n2){
                return n1.val-n2.val;
            }            
        });
        for(ListNode node:lists){
            if(node!=null){
                pq.add(node);    
            }
        }
        
        ListNode curr=dummy;
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            curr.next=node;
            curr=curr.next;
            if(node.next!=null){
                pq.add(node.next);
            }
        }
        return dummy.next;
      
    }
}

class MergeTwoSortedLinkedList{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode();
        ListNode current=result;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
              current.next=l1;
              current=current.next;  
              l1=l1.next;   
            }
            else{
              current.next=l2;
              current=current.next;  
              l2=l2.next;   
            } 
        }
         while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
              current.next=l1;
              current=current.next;  
              l1=l1.next;   
            }
            else{
              current.next=l2;
              current=current.next;  
              l2=l2.next;   
            } 
        }
         if(l1!=null){
              current.next=l1;
         }
         if(l2!=null){
              current.next=l2;
         }
        return result.next;
    }
}