package springFestival.day1;
/**
 * 循环链表
 * @author shixianhe
 *
 */
public class CircleListNode {
	
	int val;
	CircleListNode next,head;
	
	public CircleListNode(){
		head = this;
	}
	
	
	public CircleListNode(int val,CircleListNode next){
		this();
		this.val = val;
		this.next = next;
		
	}
	
	public void add(CircleListNode node){
		CircleListNode current = this;
		while(current != null && current.next != null){
			current = current.next;
		}
		current.next = node;
		node.next = head;
	}
	
	public void delete(CircleListNode node){
		CircleListNode current = this;
		while(current != null && current.next != null){
			if(current.next.val == node.val){
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
		
	}
	
	public void print(CircleListNode l){
		while(l != null){
			System.err.print(l.val + " ");
			l = l.next;
		}
		System.err.println();
	}
	
	public static void main(String[] args){
		
		CircleListNode l1 = new CircleListNode(1,null);
		CircleListNode l2 = new CircleListNode(2,null);
		CircleListNode l4 = new CircleListNode(4,null);
		CircleListNode current = new CircleListNode(0,l1);
		
		System.err.println(current.head.val);
		current.print(current);
//		
		current.add(l2);
		current.print(current);
//		current.add(l4);
//		current.print(current);
//		
//		current.delete(l4);
//		current.print(current);
//		
//		current.delete(l1);
//		current.print(current);
		
		
	}
}
