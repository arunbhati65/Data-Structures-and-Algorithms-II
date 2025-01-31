/*
We are given a binary tree (with root node root), a target node, and an integer value K.
Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
*/
class Solution {
    HashMap<TreeNode,TreeNode> map=new HashMap<>();
    HashSet<TreeNode> visited=new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result=new LinkedList<>();
        if(root==null) return result;
        inorder(root,null);
        Queue<TreeNode> queue=new LinkedList<>();
        visited.add(target);
        queue.add(target); int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            if(level==K){
                for(int i=0;i<size;++i){
                    TreeNode curr=queue.poll();
                    result.add(curr.val);
                }
                 return result;
            }
            for(int i=0;i<size;++i){
                TreeNode curr=queue.poll();
                visited.add(curr);
                if(curr.left!=null && !visited.contains(curr.left)){queue.add(curr.left);}
                if(curr.right!=null && !visited.contains(curr.right)){queue.add(curr.right);}
                if(map.get(curr)!=null &&!visited.contains(map.get(curr))){queue.add(map.get(curr));}
            }
             ++level;
        }
        return result;
        
    }
    void inorder(TreeNode root,TreeNode prev){
        if(root==null) return ;
        if(prev!=null){
            map.put(root,prev);
        }
        inorder(root.left,root);
        inorder(root.right,root);
    }
}