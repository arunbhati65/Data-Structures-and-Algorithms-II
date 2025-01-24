class Solution {
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        int[] temp={k};
        return helper(root,temp);
        
    }
    
    int helper(Node node,int[] k){
        if(node==null) return Integer.MIN_VALUE;
        int right=helper(node.right,k);
        if(right!=Integer.MIN_VALUE) return right;
        k[0]--;
        if(k[0]==0) return node.data;
        return helper(node.left,k);
    }
}


class Solution {
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        return inorderHelper(root,k).val;
    }
    TreeNode inorderHelper(TreeNode root,int k){
        if(root==null) return null;
        TreeNode left=inorderHelper(root.left,k);
        if(left!=null) return left;
        count++;
        if(k==count) return root;
        return inorderHelper(root.right,k);    
    }
}
