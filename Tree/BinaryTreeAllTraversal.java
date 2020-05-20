import java.util.Queue;
import java.util.LinkedList;
//		1
//	      2	  3
//         4  5   6  7
public class BinaryTreeAllTraversal{

	static void inOrderTraversal(BTNode root){
		if(root==null) return;
		inOrderTraversal(root.left);
		System.out.print(root.data+"--");
		inOrderTraversal(root.right);
	}
	
	static void preOrderTraversal(BTNode root){
		if(root==null) return;
		System.out.print(root.data+"--");
		inOrderTraversal(root.left);
		inOrderTraversal(root.right);
	}
	static void postOrderTraversal(BTNode root){
		if(root==null) return;
		inOrderTraversal(root.left);
		inOrderTraversal(root.right);
		System.out.print(root.data+"--");
	}

	static void levelOrderTraversal(BTNode root){
		Queue<BTNode> queue=new LinkedList<BTNode>();
		queue.offer(root);
		BTNode currentNode=null;
		while(!queue.isEmpty()){
			currentNode=queue.poll();
			System.out.print(currentNode.data+"--");
			if(currentNode.left!=null){
				queue.offer(currentNode.left);
			}
			if(currentNode.right!=null){
				queue.offer(currentNode.right);
			}
		}
	}

	public static void main(String args[]){
		BTNode root=new BTNode(1);
		root.left=new BTNode(2);
		root.right=new BTNode(3);
		root.left.left=new BTNode(4);
		root.left.right=new BTNode(5);
		root.right.left=new BTNode(6);
		root.right.right=new BTNode(7);

		//DFS traversals
		System.out.print("Inorder Traversal :-");inOrderTraversal(root);
		System.out.print("\nPreorder Traversal :-");preOrderTraversal(root);
		System.out.print("\nPostOrder Traversal :-");postOrderTraversal(root);
		System.out.print("\nlevelOrder Traversal :-");levelOrderTraversal(root);
	}
}

class BTNode{
	public int data;
	public BTNode left;
	public BTNode right;

	public BTNode(){
	}

	public BTNode(int data,	BTNode left,BTNode right){
		this.data=data;
		this.left=left;
		this.right=right;
	}

	public BTNode(int data){
		this.data=data;
	}
}