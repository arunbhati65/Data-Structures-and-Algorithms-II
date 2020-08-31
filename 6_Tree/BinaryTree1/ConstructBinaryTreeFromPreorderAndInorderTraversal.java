class Solution {
    int preOrderIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,inorder.length);
    }
    
    TreeNode helper(int [] pre,int[] in,int len){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<len;++i){
            map.put(in[i],i);
        }
        return buildTree(pre,0,len-1,map);
    }
    
    TreeNode buildTree(int [] pre,int inStartIndex,int inEndIndex,HashMap<Integer,Integer> map){
        if(preOrderIndex==pre.length) return null;
        if(inStartIndex>inEndIndex) return null;
        TreeNode root=new TreeNode(pre[preOrderIndex++]);
        root.left=buildTree(pre,inStartIndex,map.get(root.val)-1,map);
        root.right=buildTree(pre,map.get(root.val)+1,inEndIndex,map);
        return root;
    }
}