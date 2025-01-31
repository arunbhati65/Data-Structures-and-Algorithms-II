class Solution {
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        return inorderHelper(root,k).val;
    }
    TreeNode inorderHelper(TreeNode root,int k){
        if(root==null) return null;
        TreeNode left=inorderHelper(root.left,k);
        if(left!=null) return left;
        count++;
        if(k==count) return root;
        return inorderHelper(root.right,k);    
    }
}