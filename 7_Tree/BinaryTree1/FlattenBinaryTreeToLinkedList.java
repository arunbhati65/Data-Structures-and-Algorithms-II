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
    TreeNode tail=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        preOrder(root);
    }
    
    void preOrder(TreeNode root){
        if(root==null) return ;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        if(tail == null) 
            tail = root ;
        else {
            tail.right = root;
            tail = root;
        }
        preOrder( left);
        preOrder( right);
    }
}