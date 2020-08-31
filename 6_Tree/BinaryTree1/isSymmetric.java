class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
    }
    
    boolean helper(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null) return true;
        if((root1==null && root2!=null)||(root2==null && root1!=null)) return false;
        if(root1.val!=root2.val) return false;
        if(!helper(root1.left,root2.right)) return false;
        if(!helper(root1.right,root2.left)) return false;
        return true;
    }
}