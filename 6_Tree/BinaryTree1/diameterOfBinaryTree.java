class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        //return 0 if root have no child
        return Math.max(height(root.left)+height(root.right),Math.max(diameterOfBinaryTree(root.left),
                                          diameterOfBinaryTree(root.right)));
    }
    
    public int height(TreeNode root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }  
}