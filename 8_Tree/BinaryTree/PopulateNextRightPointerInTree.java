class Solution { //100
    public Node connect(Node root) {
        Node left=root;
        while(left!=null && left.left!=null){
            connectPointerLevelWise(left);
            left=left.left;
        }
        return root;
    }
    
    void connectPointerLevelWise(Node node){
        Node itr=node;
        while(itr!=null){
            itr.left.next=itr.right;
            if(itr.next!=null){
                itr.right.next=itr.next.left;
            }
            itr=itr.next;
        }
    }
}

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

class Solution { //45
  public Node connect(Node root) {
      if(root==null) return root;
      helper(root.left,root.right);
      return root;
  }
    
  void helper(Node left,Node right){
      if(left==null) return;
      left.next=right;
      helper(left.right,right.left);
      connect(left);
      connect(right);
  }

}

class Solution { //55
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
