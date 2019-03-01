package dynamic_programming;

/**
 * 1 / \ 1 1 / \ / \ 1 2 1 / \ / \ / \ 1 3 3 1 / \ / \ / \ / \ 1 4 6 4 1 / \ / \
 * / \ / \ / \ 1 5 10 10 5 1
 * 
 * @author shixianhe
 *
 */
public class YanghuiTriangle {
	
	public static class NodeList{
		int val;
		NodeList next;
		public NodeList(int val){
			this.val = val;
		}
	}
	
	public NodeList reverse(NodeList l){
		
		NodeList cur = l;
		NodeList pre = null;
		while(cur != null){
			NodeList tmp = cur.next;
//			tmp.next = cur;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		
		return pre;
	}

	public static int fun(int i, int j) {
		if (j == 1 || i == j) {
			return 1;
		} else {
			return fun(i - 1, j) + fun(i - 1, j - 1);
		}
	}

	public static void main(String[] args) {
//		int length = 10; // 打印的行数
//
//		for (int i = 1; i <= length; i++) {
//
//			// 打印空格
//			for (int j = 1; j <= length - i; j++) {
//				System.out.print("  ");
//			}
//			for (int j = 1; j <= i; j++) {
//				System.out.printf("%4d", fun(i, j));
//			}
//			System.out.println();
//		}
		
		NodeList l1 = new NodeList(1);
		NodeList l2 = new NodeList(2);
		NodeList l3 = new NodeList(3);
		NodeList l4 = new NodeList(4);
		NodeList l5 = new NodeList(5);
		l1.next =l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		NodeList l = new YanghuiTriangle().reverse(l1);
		while(l != null){
			System.err.print(l.val + " ");
			l = l.next;
		}
	}
}
