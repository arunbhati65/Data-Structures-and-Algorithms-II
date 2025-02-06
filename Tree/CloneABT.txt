class GfG{
    static Map<Integer,Tree> map=new HashMap<>();
    public static Tree cloneTree(Tree root){
        
       DFS(root);
       helper(root);
       return map.get(root.data);
     }
     
     static void DFS(Tree node){
         if(node==null) return;
         map.put(node.data,new Tree(node.data));
         helper(node.left);
         helper(node.right);
     }
     
     static void helper(Tree node){
         if(node==null) return ;
         helper(node.left);
         Tree curr=map.get(node.data);
         if(curr!=null){
             curr.random=node.random==null?null:map.get(node.random.data);
             curr.left=node.left==null?null:map.get(node.left.data);
             curr.right=node.right==null?null:map.get(node.right.data);             
         }
         helper(node.right);
     }
}