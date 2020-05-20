public class ReverseList{
	static void printAll(Node head){
		while(head.next!=null){
			System.out.println(head.data);
			head=head.next;
		}
	}	

	public static void main(String args[]){
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);
		head.next.next.next.next.next=new Node(6);
		head.next.next.next.next.next.next=new Node(7);

		printAll(head);	
	}
}

class Node{
	public int data;
	public Node next;

	public Node(){
		
	}
	public Node(int data){
		this.data=data;
		
	}
	public Node(int data,Node next){
		this.data=data;
		this.next=next;
	}
}