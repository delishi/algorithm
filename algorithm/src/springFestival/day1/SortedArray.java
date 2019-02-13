package springFestival.day1;

/**
 * 大小固定的有序数组
 * 
 * @author shixianhe
 *
 */
public class SortedArray {

	public int[] array;

	public int size = 0;

	public int capacity = 0;

	public SortedArray(int capacity) {
		this.capacity = capacity;

		array = new int[capacity];
	}

	public void add(int data) {
		if (size == capacity) {
			throw new RuntimeException("the array is full");
		}

		int index = find(data,"gt");

		for (int i = size-1 ; i >= index; i--) {
			array[i + 1] = array[i];
		}
		array[index] = data;

		size++;
	}

	public int delete(int data) {
		if(size == 0){
			throw new RuntimeException("the array is empty");
		}
		int index = find(data,"eq");
		
		if(index == -1){
			throw new RuntimeException("no data exists in the array");
		}
		int ret = array[index];
		for(int i=index;i<size-1;i++){
			array[i] = array[i+1];
		}
		array[size-1] = 0;
		size--;
		return ret;
	}

	public void update(int index , int data) {
		if(index <0 || index > size){
			throw new RuntimeException("index is not right");
		}
		array[index] = data;
	}

	private int find(int data,String type) {
		if("eq".equals(type)){
			for (int i = 0; i < array.length - 1; i++) {
				if(array[i] == data){
					return i;
				}
			}
			return -1;
		}else{
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] <= data && array[i + 1] >= data) {
					return i+1;
				} else if (array[0] > data) {
					return 0;
				}
			}
			return size;
		}
		
	}

	public static void main(String[] args) {
		SortedArray sa = new SortedArray(10);
		sa.add(1);
		sa.add(5);
		sa.add(3);
		sa.add(7);
		sa.add(5);
		sa.add(9);
		sa.add(11);
		sa.add(8);
		sa.add(29);
		sa.add(6);
//		sa.add(0);
		for (int i = 0; i < sa.array.length; i++) {
			System.err.print(sa.array[i] + " ");
		}
		System.err.println();
		sa.delete(11);
		sa.delete(5);
//		sa.delete(2);
		for (int i = 0; i < sa.array.length; i++) {
			System.err.print(sa.array[i] + " ");
		}
		System.err.println();
		sa.update(1, 100);
		for (int i = 0; i < sa.array.length; i++) {
			System.err.print(sa.array[i] + " ");
		}
		System.err.println();
	}
}
