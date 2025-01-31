import java.util.Stack;

public class printAllPath {
	public static void main(String args[]) 
	{ 
		TNode root = new TNode(10); 
		root.left = new TNode(8); 
		root.right = new TNode(2); 
		root.left.left = new TNode(3); 
		root.left.right = new TNode(5); 
		root.right.left = new TNode(2); 
		
		printPaths(root); 
	}

    private static void printPaths(TNode root) {
        Stack<Integer> s=new Stack<>();
        inorder(root,s);
    }

    private static void inorder(TNode root, Stack<Integer> s) {
        if(root==null) return;
        s.push(root.data);
        inorder(root.left, s);
        if(root.left==null && root.right==null){
            printStack(s);
        }
        inorder(root.right, s);
        s.pop();
    }

    private static void printStack(Stack<Integer> s) {
        if(s.isEmpty()){
            System.out.println("");
            return;
        }
        int top=s.pop();
        System.out.print(top+" ");
        printStack(s);
        s.push(top);
    }
} 

 class TNode{
    int data;
    TNode left;
    TNode right;

    TNode(int data){
        this.data=data;
    }
}