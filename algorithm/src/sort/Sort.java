package sort;

public class Sort {
	// =================quick sort start===========================
	public int[] quickSort(int[] nums) {
		int n = nums.length;
		quickSort(nums, 0, n - 1);

		return nums;
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
		// temperary variable
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
		for (int k = 0; k < nums.length; k++) {
			System.err.print(nums[k] + " = ");
		}
		System.err.println();
		return i;
	}
	// =================quick sort end=============================
	/** =================merge sort start===========================*/
	public int[] mergeSort(int[] nums) {
		int n = nums.length;
		mergeSort(nums, 0, n - 1);

		return nums;
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
		int[] tmp = new int[r-p + 1];
		int i = p;
		int j = q + 1;
		int k = 0;
		while(i<=q && j <= r){
			if(nums[i] < nums[j]){
				tmp[k++] = nums[i++];
			}else{
				tmp[k++] = nums[j++];
			}
		}
		int start = i;
		int end = q;
		if(j<=r){
			start = j;
			end = r;
		}
		while(start <= end){
			tmp[k++] = nums[start++];
		}
		
		for(int l=0;l<=r-p;l++){
			nums[p+l] = tmp[l];
		}
	}
	/** =================merge sort end===========================*/
	
	public static void main(String[] args) {
		// quick sort
		// int[] nums = new Sort().quickSort(new int[]{11,8,3,9,7,1,2,5});
		// for(int i=0;i<nums.length;i++){
		// System.err.print(nums[i] + " ");
		// }
		// merge sort
		int[] nums = new Sort().mergeSort(new int[]{11,8,3,9,7,1,2,5});
		for (int i = 0; i < nums.length; i++) {
			System.err.print(nums[i] + " ");
		}
	}
}
