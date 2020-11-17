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
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        curr=new TreeNode();
        TreeNode dummy=curr;
        helper(root);
        return dummy.right;
    }
    
    void helper(TreeNode node){
        if(node==null) return ;
        helper(node.left);
        node.left=null;
        curr.right=node;
        curr=node;
        helper(node.right);        
    }
}

class Solution {//Inorder traversal
    public void flatten(TreeNode root) {
        if(root==null) return;
        helper(root);
    }
    
    TreeNode helper(TreeNode node){
        if(node==null) return node;
        TreeNode root=node;
        TreeNode left=helper(node.left);
        node.left=null;
        TreeNode next=node.right;
        if(left!=null){
            node.right=left; 
            while(node.right!=null){
                node=node.right;
            }
            node.right=next;
        }
        helper(next);
        return root;
    }
}

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
