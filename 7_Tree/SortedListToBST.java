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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {//100
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return helper(head);
    }
    
    TreeNode helper(ListNode l){
        if(l==null) return null;
        if(l.next==null){
            return new TreeNode(l.val);
        }
        ListNode middle=findMiddle(l);
        TreeNode newNode=new TreeNode(middle.next.val);
        ListNode right=middle.next.next;
        middle.next=null;
        newNode.left=helper(l);
        newNode.right=helper(right);
        return newNode;
    }
    
    ListNode findMiddle(ListNode node){
        ListNode ptr1=node,ptr2=node,prev=node;
        while(ptr2!=null && ptr2.next!=null){
            prev=ptr1;
            ptr1=ptr1.next;
            ptr2=ptr2.next.next;
        }
        return prev;
    }
}

class Solution {//100
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }
    
    TreeNode helper(ListNode head){
        if(head==null) return null; 
        ListNode fast=head,slow=head,tail=null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next; tail=slow; slow=slow.next;
        }
        if(tail!=null){ tail.next=null; }
        TreeNode root=new TreeNode(slow.val);
        if(head==slow) return root;
        root.left=helper(head); root.right=helper(slow.next);
        return root;
    }
}

class Solution { //50%
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        return helper(head,tail);
    }
    
    TreeNode helper(ListNode l,ListNode h){
        if(l==null || l.val>h.val) return null;
        if(l==h){
            return new TreeNode(l.val);
        }
        ListNode middle=findMiddle(l);
        TreeNode newNode=new TreeNode(middle.next.val);
        ListNode right=middle.next.next;
        middle.next=null;
        newNode.left=helper(l,middle);
        newNode.right=helper(right,h);
        return newNode;
    }
    
    ListNode findMiddle(ListNode node){
        ListNode ptr1=node,ptr2=node,prev=node;
        while(ptr2!=null && ptr2.next!=null){
            prev=ptr1;
            ptr1=ptr1.next;
            ptr2=ptr2.next.next;
        }
        return prev;
    }
}
