import java.lang.Math;

//		1
//	      2	  3
//         4  5   6  7
public class BinaryTreeHeight{

static int getHeightOfTree(BTNode root){
	if(root==null) return 0;
	return (1+Math.max(getHeightOfTree(root.left),getHeightOfTree(root.right)));	
}

public static void main(String args[]){
	BTNode root=new BTNode(1);
	root.left=new BTNode(2);
	root.right=new BTNode(3);
	root.left.left=new BTNode(4);
	root.left.right=new BTNode(5);
	root.right.left=new BTNode(6);
	root.right.right=new BTNode(7);

	System.out.println("height of the tree is :--  "+getHeightOfTree(root));
}

}

class Solution {
    int maxDepth=Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        DFS(root,1);
        return maxDepth;
    }
    
    void DFS(TreeNode node,int depth){
        if(node == null) return ;
        maxDepth=Math.max(maxDepth,depth);
        DFS(node.left,depth+1);
        DFS(node.right,depth+1);
    }
}