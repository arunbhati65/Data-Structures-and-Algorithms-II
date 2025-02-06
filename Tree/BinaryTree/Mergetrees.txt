class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return inorder(t1,t2);
    }
    
    TreeNode inorder(TreeNode t1,TreeNode t2){
        if(t1==null && t2==null) return null;
        if(t2==null) return t1;
        if(t1==null) return t2;
        t1.left=inorder(t1.left,t2.left);
        t1.right=inorder(t1.right,t2.right);
        t1.val=t1.val+t2.val;
        return t1;
    }
}