package springFestival.day2;

/**
 * 基于链表的链式栈
 * 
 * @author shixianhe
 *
 */
public class LinkedQueue {
	
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode dummy = new ListNode(0);
	
	public ListNode head = null;
	
	public LinkedQueue(){
		
	}
	

	public void enque(int data) {
		ListNode l = new ListNode(data);
//		if(head == null){
//			head = l;
//			dummy.next = head;
//		}else{
//			l.next = head;
//			head = l;
//		}
		l.next = head;
		head = l;
		dummy.next = head;
	}

	public int deque() {
		head = dummy.next;
		if (isEmpty()) {
			throw new RuntimeException("queue is empty");
		}
		if(head.next == null){
			dummy.next = null;
			return head.val;
		}
		//找到倒数第二个节点
		ListNode last2ndNode = null;
		while(head.next != null){
			if(head.next.next == null){
				last2ndNode = head;
				break;
			}
			head = head.next;
		}
		int ret = last2ndNode.next.val;
		last2ndNode.next = null;
		return ret;
	}

	public boolean isEmpty() {
		head = dummy.next;
		return head == null;
	}

	public void traverse() {
		head = dummy.next;
		while(head != null){
			System.err.print(head.val + " ");
			head = head.next;
		}
		System.err.println();
	}
}
