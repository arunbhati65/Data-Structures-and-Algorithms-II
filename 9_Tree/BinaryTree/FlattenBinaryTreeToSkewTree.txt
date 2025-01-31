class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return ;
        TreeNode right=root.right;
        flatten(root.left);
        root.right=root.left;
        root.left=null;
        flatten(right);
        TreeNode temp=root;
        while(temp.right!=null){
            temp=temp.right;
        }
        temp.right=right;
    }
}