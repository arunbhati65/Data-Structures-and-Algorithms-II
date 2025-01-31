/*
Given two binary search trees(BST) root1 and root2.
Return a list containing all the integers from both trees sorted in ascending order.
*/
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        root1=flatten(root1);
        root2=flatten(root2);
        List<Integer> list=new LinkedList<>();
        while(root1!=null && root2!=null){
            if(root1.val>=root2.val){
                list.add(root2.val);
                root2=root2.right;
            }else{
                list.add(root1.val);
                root1=root1.right;                
            }
        }
        while(root1!=null){
                list.add(root1.val);
                root1=root1.right;
        }
        while(root2!=null){
                list.add(root2.val);
                root2=root2.right;
        }
        return list;
    }
    
    TreeNode dummy=null,prev;
    TreeNode flatten(TreeNode root){
       if(root==null) return null;
        dummy=new TreeNode(-1);
        prev=dummy;
        inorder(root);
        return dummy.right;
    }
    
    void inorder(TreeNode root){
       if(root==null) return; 
       inorder(root.left);
       prev.left=null;
       prev.right=root;
       prev=prev.right; 
       inorder(root.right);
    }
}