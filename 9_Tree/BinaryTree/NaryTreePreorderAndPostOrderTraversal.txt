class Solution {
    List<Integer> traverse=new ArrayList<>();
    public List<Integer> preorder(Node root) {
        helperPreorder(root);
        return traverse;
    }
    
    void helperPreorder(Node root){
        if(root==null) return;
        traverse.add(root.val);
        for(Node child:root.children){
            helperPreorder(child);
        }
    }
}

class Solution {
    List<Integer> traverse=new ArrayList<>();
    public List<Integer> postorder(Node root) {
        helperPostorder(root);
        return traverse;
    }
    
    void helperPostorder(Node root){
        if(root==null) return;
        for(Node child:root.children){
            helperPostorder(child);
        }
        traverse.add(root.val);
    }
}