package springFestival.day2;
/**
 * 基于数组的队列
 * @author shixianhe
 *
 */
public class ArrayQueue {
	
	public int size;
	
	public int capacity = 10;
	
	public int[] element = new int[capacity];
	
	public void enque(int data){
		if(size == capacity){
			throw new RuntimeException("queue is full");
		}
		for(int i=size-1;i>=0;i--){
			element[i+1] = element[i];
		}
		element[0] = data;
		size++;
	}
	
	public int deque(){
		if(size == 0){
			throw new RuntimeException("queue is empty");
		}
		int ret = element[--size];
		element[size] = 0;
		return ret;
	}
	
	public void traverse() {
		for (int i = 0; i < size; i++) {
			System.err.print(element[i] + " ");
		}
		System.err.println();
	}
	
}
