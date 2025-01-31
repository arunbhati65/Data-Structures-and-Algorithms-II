public class ReverseList{
	static void printAll(Node head){
		while(head!=null){
			System.out.print(head.data+"->");
			head=head.next;
		}
		System.out.print("\n");
	}
	//prev  current
	//null   //1       2 3 4 5 6
	static Node reverseList(Node head){
		Node current=head;
		Node prev=null;
		Node temp;
		while(current!=null){
			temp=current.next;
			current.next=prev;
			prev=current;
			current=temp;
		}
		head=prev;
		return head;
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
		printAll(reverseList(head));	
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