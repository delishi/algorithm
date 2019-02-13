package springFestival.day3;

public class Sort {
	public int[] bubbleSort(int[] a) {
		int n = a.length;
		boolean flag = false;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}

		return a;
	}

	public int[] insertSort(int[] a) {
		int n = a.length;

		for (int i = 1; i < n; i++) {
			int value = a[i];
			for (int j = i - 1; j >= 0; j--) {
				if (value < a[j]) {
					a[j + 1] = a[j];
					a[j] = value;
				}
			}
		}
		return a;
	}

	// =================quick sort start===========================
	public int[] quickSort(int[] a) {
		int n = a.length;
		quickSort(a, 0, n - 1);

		return a;
	}

	private void quickSort(int[] nums, int p, int r) {
		if (p >= r)
			return;
		int q = partition(nums, p, r);
		quickSort(nums, p, q - 1);
		quickSort(nums, q + 1, r);

	}

	private int partition(int[] nums, int p, int r) {
		// we usually use the last element as the pivot
		int pivot = nums[r];
		int i = p;
		// temporary variable
		int tmp = 0;
		for (int j = p; j < r; j++) {
			if (nums[j] < pivot) {
				tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
			}
		}
		tmp = nums[i];
		nums[i] = nums[r];
		nums[r] = tmp;
		return i;
	}

	// =================quick sort end=============================
	/** =================merge sort start=========================== */
	public int[] mergeSort(int[] a) {
		int n = a.length;
		mergeSort(a, 0, n - 1);

		return a;
	}

	private void mergeSort(int[] nums, int p, int r) {
		if (p >= r)
			return;
		int q = (p + r) / 2;
		mergeSort(nums, p, q);
		mergeSort(nums, q + 1, r);
		merge(nums, p, q, r);

	}

	public void merge(int[] nums, int p, int q, int r) {
		int[] tmp = new int[r - p + 1];
		int i = p;
		int j = q + 1;
		int k = 0;
		while (i <= q && j <= r) {
			if (nums[i] < nums[j]) {
				tmp[k++] = nums[i++];
			} else {
				tmp[k++] = nums[j++];
			}
		}
		int start = i;
		int end = q;
		if (j <= r) {
			start = j;
			end = r;
		}
		while (start <= end) {
			tmp[k++] = nums[start++];
		}

		for (int l = 0; l <= r - p; l++) {
			nums[p + l] = tmp[l];
		}
	}

	/** =================merge sort end=========================== */

	// 从未排序数组中选出最小的，与已排序数组中的最小值交换
	public int[] selectSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {

			int j = i + 1;
			int k = j;
			int minimum = a[j];
			for (; j < n; j++) {
				// find minimum
				if (a[j] < minimum) {
					minimum = a[j];
					k = j;
				}
			}
			// swap
			if (a[i] > a[k]) {
				int tmp = a[i];
				a[i] = a[k];
				a[k] = tmp;
			}

		}
		return a;
	}

}
