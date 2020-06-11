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
class Solution {
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