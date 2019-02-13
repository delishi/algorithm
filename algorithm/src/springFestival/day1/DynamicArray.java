package springFestival.day1;

import java.util.Arrays;

/**
 * https://time.geekbang.org/column/article/80456 支持动态扩容的数组
 * 
 * @author shixianhe
 *
 */
public class DynamicArray {

	public int size;
	public static int MAX_SIZE = 10;
	public static int[] array = new int[MAX_SIZE];

	public void insert(int index, int o) {
		if (index < 0 || index > size) {
			return;
		}
		if (size == MAX_SIZE) {
			// 扩容
			// Object[] newArray = new Object[MAX_SIZE*2];
			MAX_SIZE *= 2;
			array = Arrays.copyOf(array, MAX_SIZE);
			// array = newArray;
		}

		for (int i = index; i <= size - 1; i++) {
			array[i + 1] = array[i];
		}

		array[index] = o;

		size++;
	}

	public int delete(int index) {
		if (index < 0 || index > size) {
			return 0;
		}
		int ret = array[index];
		for (int i = index + 1; i < size; i++) {
			array[i-1] = array[i];
		}
		size--;
		if(size == array.length /2){
			MAX_SIZE /= 2;
			array = Arrays.copyOf(array, MAX_SIZE);
		}
		return ret;
	}

	public Object find(int index) {
		if (index < 0 || index > size) {
			return null;
		}

		return array[index];
	}

	public static void main(String[] args) {
		// int[] a = new int[] { 1, 2, 3 };
		// a = Arrays.copyOf(a, 6);
		// for (int i = 0; i < a.length; i++) {
		// System.err.println(a[i] + " ");
		// }
		DynamicArray array = new DynamicArray();
		array.insert(0, 1);
		array.insert(1, 1);
		array.insert(2, 1);
		array.insert(3, 1);
		array.insert(4, 1);
		array.insert(5, 1);
		array.insert(6, 1);
		array.insert(7, 1);
		array.insert(8, 1);
		array.insert(9, 1);
		for (int i = 0; i < array.array.length; i++) {
			System.err.print(array.array[i] + " ");
		}
		System.err.println();
		array.insert(3, 3);
		for (int i = 0; i < array.array.length; i++) {
			System.err.print(array.array[i] + " ");
		}
		array.delete(3);
		System.err.println();
		for (int i = 0; i < array.array.length; i++) {
			System.err.print(array.array[i] + " ");
		}

	}
}
