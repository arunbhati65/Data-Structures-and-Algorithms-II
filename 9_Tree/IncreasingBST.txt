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