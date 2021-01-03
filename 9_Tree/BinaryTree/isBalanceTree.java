public class isBalanceTree {

    static Boolean isBalanced = true;

    static boolean checkBalancedTree(Node root) {
        if (root == null)
            return true;
        postOrder(root);
        return isBalanced;
    }

    static int postOrder(Node root){
        if(isBalanced==false) return -1;
        if(root==null) return -1;
        int left=postOrder(root.left);
        int right=postOrder(root.right);
        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return 1+Math.max(left,right);
    }
    public static void main(String[] args) {
        /* Constructed binary tree is 
                   1 
                 /   \ 
                2      3 
              /  \    / 
            4     5  6 
            / 
           7         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
       // root.right.right = new Node(6);
        root.left.left.left = new Node(7);

        System.out.println(checkBalancedTree(root));
    }
}

class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
