/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/
class The_Comparator implements Comparator<ListNode> { 
    public int compare(ListNode l1, ListNode l2) 
    {  
        return l1.val-l2.val; 
    } 
} 

class MergeKSortedLists{
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode result=new ListNode();
        ListNode current=result,top=null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>(lists.length,new The_Comparator());
        for(int i=0;i<lists.length;++i){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        while(!pq.isEmpty()){
            top=pq.poll();//main point
         
            if(top.next!=null){
                pq.add(top.next);    
            }
            current.next=top;
            current= current.next;
        }
        
      return result.next;  
    }
}