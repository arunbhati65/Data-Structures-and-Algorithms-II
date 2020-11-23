/**
Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.  (The values of the nodes may still be duplicates.)
Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
The right-most node is also defined by the same way with left and right exchanged.
 */
class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root==null) return result;
        result.add(root.val);
        addLeftBoundary(root.left);
        if(root.left!=null || root.right!=null){
            addLeaves(root);
        }
        addRightBoundary(root.right);
        return result;
    }
    
    void addRightBoundary(TreeNode root){
        if(root==null)return ;
        if(root.right!=null){
            addRightBoundary(root.right);
            result.add(root.val); 
        }else if(root.left!=null){
            addRightBoundary(root.left);
            result.add(root.val); 
        }     
    }
    
    void addLeftBoundary(TreeNode root){
        if(root==null)return ;
        if(root.left!=null){
            result.add(root.val);     
            addLeftBoundary(root.left);
        }else if(root.right!=null){
            result.add(root.val);     
            addLeftBoundary(root.right);
        }     
    }
    
    void addLeaves(TreeNode root){
        if(root==null)return ;
        addLeaves(root.left);
        if(root.left==null && root.right==null){
            result.add(root.val);
        }
        addLeaves(root.right);
    }
}