/**
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered
 from top to bottom.
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        if(root==null) return list;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            TreeNode curr=null;
            for(int i=0;i<size;++i){
                curr=q.poll();
                if(i==size-1){list.add(curr.val);}
                if(curr.left!=null){q.add(curr.left);}
                if(curr.right!=null){q.add(curr.right);}
            }
        }
        return list;
    }
}