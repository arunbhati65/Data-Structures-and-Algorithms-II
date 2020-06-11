
class Solution {
    Integer postOrderIndex=null;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex=inorder.length-1;
        return helper(postorder,inorder,inorder.length);
    }
    
    TreeNode helper(int [] post,int[] in,int len){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<len;++i){
            map.put(in[i],i);
        }
        return buildTree(post,0,len-1,map);
    }
    
    TreeNode buildTree(int [] post,int inStartIndex,int inEndIndex,HashMap<Integer,Integer> map){
        if(postOrderIndex==-1) return null;
        if(inStartIndex>inEndIndex) return null;
        TreeNode root=new TreeNode(post[postOrderIndex--]);
        if(inStartIndex==inEndIndex) return root;
        root.right=buildTree(post,map.get(root.val)+1,inEndIndex,map);
        root.left=buildTree(post,inStartIndex,map.get(root.val)-1,map);
       
        return root;
    }
}