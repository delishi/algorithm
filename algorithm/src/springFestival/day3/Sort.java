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

	public int[] quickSort(int[] a) {
		int n = a.length;
		return null;
	}

	//递归分段求解，再合并有序数组
	public int[] mergeSort(int[] a) {
		int n = a.length;
		
		mergeSort(a,0,n-1);
		
		return null;
	}
	
	private void mergeSort(int[] a,int p,int r){
		
	}

	// 从未排序数组中选出最小的，与已排序数组中的最小值交换
	public int[] selectSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n-1; i++) {
			
			int j = i + 1;
			int k = j;
			int minimum = a[j];
			for (; j < n; j++) {
				// find minimum
				if (a[j] < minimum) {
					minimum = a[j];
					k=j;
				}
			}
			// swap
			if(a[i] > a[k]){
				int tmp = a[i];
				a[i] = a[k];
				a[k] = tmp;
			}

		}
		return a;
	}

}
