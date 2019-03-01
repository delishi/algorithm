package springFestival.day3;

/**
 * 对有序数组进行二分查找
 * 
 * @author shixianhe
 *
 */
public class BinarySearch {
	public int search(int[] a, int value) {

		int low = 0;
		int high = a.length - 1;
		int mid = 0;

		while (low <= high) {

			mid = low + (high - low) / 2;

			if (a[mid] == value) {
				return mid;
			} else if (a[mid] > value) {
				//caution
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	public int search_recursive(int[] a, int value) {
		int low = 0;
		int high = a.length - 1;
		return search_recur(a, low, high, value);
	}

	private int search_recur(int[] a, int low, int high, int value) {
		if (low >= high)
			return -1;
		int mid = low + (high - low) / 2;
		if (a[mid] == value) {
			return mid;
		} else if (a[mid] > value) {
			return search_recur(a, low, mid-1, value);
		} else {
			return search_recur(a, mid+1, high, value);
		}
	}
	//大于等于给定值的第一个元素
	public int opaque_search(int[] a, int value) {
		
		int low = 0;
		int high = a.length - 1;
		int mid = 0;

		while (low <= high) {

			mid = low + (high - low) / 2;

			if (a[mid] < value && a[mid+1] >= value) {
				return mid+1;
			} else if (a[mid] > value) {
				//caution
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return -1;
	}
}
