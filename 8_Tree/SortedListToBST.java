class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }
    
    TreeNode helper(ListNode node){
        if(node==null) return null;
        if(node.next==null) return new TreeNode(node.val);
        ListNode prev=findMiddle(node);
        ListNode middle=prev.next;
        prev.next=null;
        ListNode next=middle.next;
        middle.next=null;
        TreeNode root=new TreeNode(middle.val);
        root.left=helper(node);
        root.right=helper(next);
        return root;
    }
    
    ListNode findMiddle(ListNode node){
        ListNode f=node,s=node,prev=null;
        while(f!=null && f.next!=null){
            f=f.next.next;
            prev=s;
            s=s.next;
        }
        return prev;
    }
}
