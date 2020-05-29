import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
//		1
//	      2	  3
//         4  5   6  7
public class LevelOrderDataInReverseOrderBottomToUp{
	static Stack<BTNode> stack=new Stack();
	static void levelOrderTraversal(BTNode root){
		Queue<BTNode> queue=new LinkedList<BTNode>();
		queue.offer(root);
		BTNode currentNode=null;
		while(!queue.isEmpty()){
			currentNode=queue.poll();
			stack.push(currentNode);
			if(currentNode.left!=null){
				queue.offer(currentNode.left);
			}
			if(currentNode.right!=null){
				queue.offer(currentNode.right);
			}
		}
		
		while(!stack.isEmpty()){
			System.out.println(""+stack.pop().data);
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

		System.out.print("levelOrder Traversal in reverse order:-\n");levelOrderTraversal(root);
	}
}
