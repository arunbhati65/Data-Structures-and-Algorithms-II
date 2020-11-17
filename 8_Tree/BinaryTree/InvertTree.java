class Solution {
    public TreeNode invertTree(TreeNode root) {//100
        if(root==null){
            return root;
        }
        return invert(root);
        
    }
    
    TreeNode invert(TreeNode node){
        if(node==null) return null;
        TreeNode left=invert(node.left);
        TreeNode right=invert(node.right);
        node.left=right;
        node.right=left;
        return node;
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {//20
        helper(root);
        return root;
    }
    
    void helper(TreeNode root){
        if(root==null) return ;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        helper(root.left);
        helper(root.right);
    }
}