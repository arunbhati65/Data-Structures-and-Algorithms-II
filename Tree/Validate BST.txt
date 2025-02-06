/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode[] prev=new TreeNode[1];
        return helper(root,prev); 
    }

    boolean helper(TreeNode node,TreeNode[] prev){
        if(node==null) return true;
        if(!helper(node.left,prev)) return false;
        if(prev[0]!=null && node.val<=prev[0].val) return false;
        prev[0]=node;
        if(!helper(node.right,prev)) return false;
        return true;
    }
}


class Solution {
    Integer prev=null;
    public boolean isValidBST(TreeNode root) {
           if(root==null) return true;
           if(!isValidBST(root.left)) return false;
           if(prev!=null && prev>=root.val) return false;
           prev=root.val;
           if(!isValidBST(root.right)) return false;
           return true; 
            
    }    
}
