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