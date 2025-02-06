class Solution {
    Integer val=null;
    public boolean isUnivalTree(TreeNode root) {
        return inorder(root);
    }
    
    boolean inorder(TreeNode root){
        if(root==null) return true;
        if(!inorder(root.left)) return false;
        if(!inorder(root.right)) return false;
        if(val==null){
            val=root.val;
        }
        return val==root.val;
    }
}