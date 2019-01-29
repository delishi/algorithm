package leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * @author shixianhe
 *
 */
public class LeetCode_2_AddTwoNumbers {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode reverseListNode(ListNode head){
		
		if(head == null){
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head.next;
		ListNode pre = head;
		pre.next = null;
		while(cur != null){
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;		
		}
		return pre;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int exceed = 0;
		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int sum = x + y + exceed;
			exceed = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (exceed == 1) {
			cur.next = new ListNode(1);
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(1);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(9);

//		ListNode ret = new LeetCode_2_AddTwoNumbers().addTwoNumbers(l1, l2);
		ListNode ret = new LeetCode_2_AddTwoNumbers().reverseListNode(l1);
		while (ret != null) {
			System.err.println(ret.val);
			ret = ret.next;
		}

	}
}
