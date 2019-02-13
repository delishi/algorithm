package springFestival.day1;
/**
 * Array & Links

 * @author shixianhe
 *
 */
public class Day1 {
	
	//单链表
	public static class NodeList{
		int val;
		NodeList next;
		public NodeList(int val,NodeList next){
			this.val = val;
			this.next = next;
		}
	}
	//双链表
	public static class DoubleNodeList{
		int val;
		DoubleNodeList prev;
		DoubleNodeList next;
		public DoubleNodeList(int val,DoubleNodeList next){
			this.val = val;
			this.prev = null;
			this.next = next;
		}
	}
	//循环链表
	public static class CircleNodeList{
		int val;
		CircleNodeList head;
		public CircleNodeList(int val,CircleNodeList head){
			this.val = val;
			this.head = head;
//			head.next
		}
		
		public static CircleNodeList insertNode(CircleNodeList node){
//			while(){
//				
//			}
			
			return null;
		}
	}
	
	//超过80%是触发扩容
	private int MAX_LENGTH = 10;
	//original array
	int[] origin = null;
	
	public Day1(){
		origin = new int[MAX_LENGTH];
	}
	//实现一个支持动态扩容的数组
	public void insert(int index,int data){
		if(index >= MAX_LENGTH){
			MAX_LENGTH = MAX_LENGTH * 2;
			origin = new int[MAX_LENGTH];
		}
		origin[index] = data;
		
	}
	
	//combine two sorted array
	public int[] comBineTwoSortedArray(int[] a,int[] b){
		
		int[] ret = new int[a.length + b.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i<a.length && j < b.length){
			if(a[i] <= b[j]){
				ret[k] = a[i];
				i++;
			}else{
				ret[k] = b[j];
				j++;
			}
			k++;
		}
		if(i==a.length){
//			System.arraycopy(b, j, ret, k, b.length-j);
			for(int m=0;m<b.length-j;m++){
				ret[m+k] = b[j+m];
			}
		}
		if(j==b.length){
//			System.arraycopy(a, i, ret, k, a.length-i);
			for(int m=0;m<a.length-i;m++){
				ret[m+k] = a[i+m];
			}
		}
		return ret;
	}

	public static void main(String[] args){
		Day1 day1 = new Day1();
		System.err.println(day1.origin.length);
		for(int i=0;i<day1.origin.length;i++){
			System.err.print(day1.origin[i] + " ");
		}
		System.err.println();
//		day1.insert(2, 6);
//		day1.insert(15, 23);
//		day1.insert(19, 28);
//		day1.insert(30, 30);
		int[] ret = day1.comBineTwoSortedArray(new int[]{1,2,3,7,9,12},new int[]{5,6,7,8});
		for(int i=0;i<ret.length;i++){
			System.err.print(ret[i] + " ");
		}
		System.err.println();
	}
}
