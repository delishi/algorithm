package springFestival.day2;

public class Day2Test {
	public static void main(String[] args){
		
//		ArrayStack as = new ArrayStack();
//		as.push(3);
//		as.push(6);
////		as.traverse();
//		as.push(9);
//		as.pop();
//		as.traverse();
//		
//		/**=====================================*/
//		
		LinkedStack ls = new LinkedStack();
		ls.push(3);
		ls.pop();
		ls.push(6);
		ls.push(8);
		ls.pop();
		ls.pop();
		System.err.println(ls.isEmpty());
//		ls.traverse();
		
//		ArrayQueue aq = new ArrayQueue();
//		aq.enque(1);
//		aq.enque(2);
//		aq.enque(3);
//		
//		aq.deque();
////		aq.deque();
//		aq.traverse();
//		
//		LinkedQueue lq = new LinkedQueue();
//		lq.enque(1);
//		lq.deque();
////		lq.deque();
//		lq.traverse();
		
		
	}
}
