class Solution {
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        curr=new TreeNode();
        TreeNode dummy=curr;
        helper(root);
        return dummy.right;
    }
    
    void helper(TreeNode node){
        if(node==null) return ;
        helper(node.left);
        node.left=null;
        curr.right=node;
        curr=node;
        helper(node.right);        
    }
}

class Solution {//Inorder traversal
    public void flatten(TreeNode root) {
        if(root==null) return;
        helper(root);
    }
    
    TreeNode helper(TreeNode node){
        if(node==null) return node;
        TreeNode root=node;
        TreeNode left=helper(node.left);
        node.left=null;
        TreeNode next=node.right;
        if(left!=null){
            node.right=left; 
            while(node.right!=null){
                node=node.right;
            }
            node.right=next;
        }
        helper(next);
        return root;
    }
}