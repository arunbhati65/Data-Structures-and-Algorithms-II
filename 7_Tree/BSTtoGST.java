class Solution {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        DFS(root);
        return root;
    }
    
    void DFS(TreeNode root){
        if(root==null) return ;
        DFS(root.right);
        root.val=root.val+sum;
        sum=root.val;
        DFS(root.left);
    }
}