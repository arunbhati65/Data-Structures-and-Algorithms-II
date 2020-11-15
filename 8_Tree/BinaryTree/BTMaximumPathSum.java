/**
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes 
from some starting node to any node in the tree along the parent-child connections.
 The path must contain at least one node and does not need to go through the root.
 */
class Solution {
    int maxPathSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       helper(root);  
       return maxPathSum; 
    }
    
    int helper(TreeNode root){
        if(root==null) return 0;
        int left=helper(root.left);
        if(left<0){left=0;}
        int right=helper(root.right);
        if(right<0){right=0;}
        maxPathSum=Math.max(maxPathSum,root.val+left+right);
        return root.val+Math.max(left,right);
    }
        
}

class Solution {
    Integer result=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }
    
    int dfs(TreeNode node){
        if(node==null) return 0;
        int leftGain=Math.max(0,dfs(node.left));
        int rightGain=Math.max(0,dfs(node.right));
        result=Math.max(result,node.val+leftGain+rightGain);
        return node.val+Math.max(leftGain,rightGain);
    }
}
