import java.util.Stack;

/* 1       5
 2       4
 3       3
 4       2
 5       1 
 
   
*/
class ABR{
	void reverse(Stack<Integer> s){
		if(s.isEmpty()) return;
		int pop=s.pop();
		reverse(s);
		insertAtBottom(s,pop);
	}
	private void insertAtBottom(Stack<Integer> s, int val){
		if(s.isEmpty()){
			s.push(val);
			return;
		}
		int pop=s.pop();
		insertAtBottom(s,val);
		s.push(pop);
	}

}
