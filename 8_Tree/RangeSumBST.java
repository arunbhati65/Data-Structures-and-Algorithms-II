class Solution {
    int sum=0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null) return 0;
        if(root.left!=null && root.val>=L)rangeSumBST(root.left,L,R);
        if(root.val>=L && root.val<=R) sum=sum+root.val;
        if(root.right!=null && root.val<=R)rangeSumBST(root.right,L,R);
        return sum;
    }
}