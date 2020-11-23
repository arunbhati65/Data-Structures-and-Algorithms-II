class Solution {//100%
    int ans=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        depth(root);
        return ans;
    }  
    
    int depth(TreeNode root){
        if(root==null) return 0;
        int left=depth(root.left);
        int right=depth(root.right);
        ans=Math.max(ans,left+right);
        int depth=1+ Math.max(left,right);
        return depth;
    }
} 

class Solution { //Slow
    int ans=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        helper(root);
        return ans;
    }  
    
    void helper(TreeNode root){
        if(root==null) return ;
        helper(root.left);
        ans=Math.max(ans,depth(root.left)+depth(root.right));
        helper(root.right);
    }
    
    int depth(TreeNode root){
        if(root==null) return 0;
        int depth=1+Math.max(depth(root.left),depth(root.right));
        return depth;
    }
}

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