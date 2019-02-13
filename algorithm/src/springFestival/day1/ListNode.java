package springFestival.day1;
/**
 * 单链表
 * @author shixianhe
 *
 */
public class ListNode {
	
	int val;
	ListNode next;
	
	public ListNode(int val,ListNode next){
		this.val = val;
		this.next = next;
	}
	
	public void add(ListNode node){
		ListNode current = this;
		while(current != null && current.next != null){
			current = current.next;
		}
		current.next = node;
	}
	
	public void delete(ListNode node){
		ListNode current = this;
		while(current != null && current.next != null){
			if(current.next.val == node.val){
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
		
	}
	//反转单链表
	public ListNode reverseNode(ListNode node){
		ListNode cur = node;
		ListNode pre = null;
		while(cur != null){
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			
		}
		return pre;
	}
	//合并有序链表
	public ListNode mergeSortedNode(ListNode l1,ListNode l2){
//		ListNode head = new ListNode()
		ListNode dummy = new ListNode(0,null);
		ListNode head = dummy;
		while(l1 != null && l2 != null){
			if(l1.val <= l2.val){
				head.next = l1;
				l1 = l1.next;
			}else{
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		
		if(l1 != null){
			head.next = l1;
		}
		if(l2 != null){
			head.next = l2;
		}
		
		return dummy.next;
	}
	//合并K个有序链表
	public ListNode kMerge(ListNode[] listNodes){
		int k = listNodes.length;
		if(k == 1){
			return listNodes[0];
		}
		if(k == 2){
			return mergeSortedNode(listNodes[0],listNodes[1]);
		}
		while (k > 1) {            
            for (int i = 0; i < k / 2; i++) 
                listNodes[i] = mergeSortedNode(listNodes[i], listNodes[i + (k + 1) / 2]);
            k = (k + 1) / 2;
        }
		
		return listNodes[0];
	}
	
	//求链表的中间节点
	public ListNode midNode(ListNode node){
		
		ListNode fast = node;
		ListNode slow = node;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	//检测链表中是否有环
	public boolean isCircle(ListNode node){
		ListNode fast = node;
		ListNode slow = node;
		while(fast != null && fast.next != null){
			
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				return true;
			}
		}
		
		return false;
	}
	
	public void print(ListNode l){
		while(l != null){
			System.err.print(l.val + " ");
			l = l.next;
		}
		System.err.println();
	}
	
	public static void main(String[] args){
		
//		ListNode l1 = new ListNode(2,null);
//		ListNode l2 = new ListNode(3,null);
//		ListNode current = new ListNode(1,l1);
//		current.print(current);
//		
//		current.add(l2);
//		current.print(current);
//		
//		ListNode l4 = new ListNode(4,new ListNode(5,null));
//		
//		current.add(l4);
//		current.print(current);
//		
//		current.delete(l4);
//		current.print(current);
//		
//		current.delete(l1);
//		current.print(current);
//		current.print(current.reverseNode(current));
		/**
		 * test mergeSortedNode
		 */
		ListNode l5 = new ListNode(5,null);
		ListNode l4 = new ListNode(4,l5);
		ListNode l3 = new ListNode(3,l4);
		ListNode l2 = new ListNode(2,null);
		ListNode l1 = new ListNode(1,l2);
		
		ListNode l9 = new ListNode(18,null);
		ListNode l8 = new ListNode(14,l9);
		ListNode l7 = new ListNode(13,l8);
		ListNode l6 = new ListNode(2,l7);
		l8.next = l9;
		
		ListNode current = new ListNode(0,l1);
//		current.print(current.mergeSortedNode(l1, l6));
		
//		System.err.print(current.midNode(l1).val);
		
//		current.print(current.kMerge(new ListNode[]{l1,l3,l6}));
		
		System.err.println(current.isCircle(l6));
		
		
	}
}
