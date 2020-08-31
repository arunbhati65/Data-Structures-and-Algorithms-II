/**
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 */
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