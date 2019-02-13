package springFestival.day2;

/**
 * 基于数组的顺序栈
 * 
 * @author shixianhe
 *
 */
public class ArrayStack {
	private int capacity = 10;

	private int size;

	public int[] element = new int[capacity];

	public void push(int data) {
		if (size == capacity) {
			throw new RuntimeException("stack is full");
		}
		element[size++] = data;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		int ret = element[--size];
		
		element[size] = 0;

		return ret;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void traverse() {
		for (int i = 0; i < size; i++) {
			System.err.print(element[i] + " ");
		}
		System.err.println();
	}
}
