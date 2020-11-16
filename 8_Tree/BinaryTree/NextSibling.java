class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        Node curr=null;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;++i){
            Node prev=curr;    
            curr=q.poll();
            if(i>0){  //to skip first element of for loop from setting as next of last element of previous loop.
                prev.next=curr;                
            }    
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);  
            }
          
        }
        return root;
    }
}